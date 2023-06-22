package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.controlls.commons.Commons;
import com.example.study_servlets.daos.CarlnforsDao;
import com.example.study_servlets.daos.FactorysDao;

@WebServlet(urlPatterns = "/connectDBServlet") 
public class ConnectDBServlet extends HttpServlet {
    @Override // 상속이 된 걸 확장하는구나!! 알 수 있음
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // 클라이언트에 html화면제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "    <!-- <link rel=\"stylesheet\" href=\"../CSS/commons.css\"> -->\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class = \"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>COMPANY_ID</th>\r\n" + //
                    "                    <th>COMPANY</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";

            // - query Edit   
                        CarlnforsDao  carlnforsDao  = new CarlnforsDao();
            ArrayList carlnforsList = new ArrayList();
            carlnforsList = carlnforsDao.selectAll();

            for(int i =0; i<  carlnforsList.size(); i++)
            {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap)  carlnforsList.get(i);
                contents = contents + "  <tr>\r\n" + //
                        "                    <td>" + hashMap.get("CAR_NAME") + "</td>\r\n" + //
                        "                    <td>" + hashMap.get("YEAR") + "</td>\r\n" + //
                        "                     <td>" + hashMap.get("CAR_INFOR_ID") + "</td>\r\n" + //
                        "                    <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
                        "                </tr>\r\n";
            }

            // //FactorysDao 메소드 
            // FactorysDao factorysDao = new FactorysDao();
            // ArrayList factoryList = new ArrayList();
            // factoryList = factorysDao.selectAll();

            // for(int i =0; i< factoryList.size(); i++)
            // {
            //     HashMap hashMap = new HashMap();
            //     hashMap = (HashMap) factoryList.get(i);
            //     contents = contents + "  <tr>\r\n" + //
            //             "                    <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
            //             "                    <td>" + hashMap.get("COMPANY") + "</td>\r\n" + //
            //             "                </tr>\r\n";
            // }

            contents = contents + "</tbody>\r\n" + //
                    "</table>\r\n" + //
                    "</div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
                    
            // 클라이언트에 html화면제공
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

            // // SELECT count(*) AS CNT FROM factorys;
            // query = "SELECT count(*) AS CNT FROM factorys";
            // resultSet = statement.executeQuery(query);
            // int totalcount = 0;
            // while (resultSet.next()) {
            //     System.out.println(resultSet.getInt("CNT"));
            //     totalcount = resultSet.getInt("CNT");
            // }
            // INSERT INTO factorys
            // (COMPANY_ID,COMPANY)
            // value
            // ('CAR-01', 'AUDI');

            // String COMPANY_ID = "CAR-01";
            // String COMPANY = "AUDI";
            // // query ="INSERT INTO factorys " + "(COMPANY_ID,COMPANY) " + "value " +
            // // "('"+COMPANY_ID+"', '"+COMPANY+"') ";
            // // // 변수를 넣어줄때 싱글 쿼테이션 '' 안에 더블 쿼테이션 ""을 넣고 ++사이에 변수를 넣어줘야한다.
            // // int count = statement.executeUpdate(query);

            // COMPANY_ID = "CAR-01";
            // COMPANY = "페라리";
            // query = "UPDATE factorys " + "SET COMPANY ='" + COMPANY + "' " + "WHERE COMPANY_ID ='" + COMPANY_ID + "' "; // CAR-01
            //                                                                                                             // AUDI를
            //                                                                                                             // 페라리로
            //                                                                                                             // 업데이트

            // // DELETE FROM factorys
            // // WHERE COMPANY_ID = 'CAR-01';
            // query = "DELETE FROM factorys " + "WHERE COMPANY_ID = '" + COMPANY_ID + "'"; // CAR-01 페라리 삭제

            // int count = statement.executeUpdate(query);

            // System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage()); // 에러 내용을 볼수 있는 명령문
            // TODO: handle exception
        }
        System.out.println();
    }

}