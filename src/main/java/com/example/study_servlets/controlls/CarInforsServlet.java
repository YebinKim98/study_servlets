package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.controlls.commons.Commons;

// - select car_infors : log에 내용 출력
// - insert 작성 : CAR_INFOR_ID는 UUID 사용
// - DB는 하나로 사용

@WebServlet(urlPatterns = "/carInforsServlet") 
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.39:3306/db_cars"; // local host보다는 ip주소로 하기
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password); 
            System.out.println("DB연결 성공\n");
            
            Commons commons = new Commons();
          
            Statement statement = connection.createStatement();
            //insert문 
            String query2 = "insert into car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "values\n" + //
                    "('뉴효원', '2023', '" +commons.generateUUID()+ "', 'C002')";
            int count = statement.executeUpdate(query2);

            // - query Edit
            String query ="SELECT * FROM db_cars.car_infors;";
            ResultSet resultSet = statement.executeQuery(query); 
            while(resultSet.next()){
                System.out.println( resultSet.getString("CAR_NAME")+" "+resultSet.getString("YEAR")+" "+resultSet.getString("CAR_INFOR_ID")+" "+resultSet.getString("COMPANY_ID"));
            }
      

     } catch (Exception e) {
           System.out.println(e.getMessage());// TODO: handle exception
     }
     System.out.println();
    }
}
