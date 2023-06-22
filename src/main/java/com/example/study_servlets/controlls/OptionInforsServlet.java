package com.example.study_servlets.controlls;

import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.controlls.commons.Commons;

@WebServlet(urlPatterns = "/optionInforsServlet")
public class OptionInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트에게 받아온다 : HttpServletRequest request
        // 클라이언트에게 보내준다 : HttpServletResponse response
        try {
            Commons commons = new Commons();
            Statement statement =commons.getStatement(); //Editor in Workbanch
            String query ="select *\n" + //
                    "from option_infors;";

            ResultSet resultSet = statement.executeQuery(query);      
            // while(resultSet.next())
            // {
            //         System.out.println(resultSet.getString("OPTION_INFOR_ID")+","
            //                             +resultSet.getString("OPTION_NAME"));
            // } //터미널에서만 확인됨 html안넣은 상태

            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                    "                    <th>OPTION_NAME</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";
                    
                    while(resultSet.next()){
                    contents = contents + "                <tr>\r\n"+//
                    "                        <td>"+resultSet.getString("OPTION_INFOR_ID")+"</td>\r\n" + //
                    "                    <td>"+resultSet.getString("OPTION_NAME")+"</td>\r\n" + //
                    "                </tr>\r\n";
                     }
                    contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" + //
                    "</html>";

            // getWriter 전에 Charset하기 
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}