package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.controlls.commons.Commons;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optioninforsJSPservlet")
public class OptionInforsJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String search = request.getParameter("search");
      
            OptionInforsDao optionInforDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList();
            optionInforList = optionInforDao.SelectWithSearch(search);

            request.setAttribute("search", search);
            request.setAttribute("optionInforList", optionInforList);

            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);

            for (int i = 0; i < optionInforList.size(); i++) {
                HashMap optionInforRecord = new HashMap();
                optionInforRecord = (HashMap) optionInforList.get(i);
                // contents = contents + "                <tr>\r\n" + //
                //         "                    <td>" + optionInforRecord.get("OPTION_INFOR_ID") + "</td>\r\n" + //
                //         "                    <td>" + optionInforRecord.get("OPTION_NAME") + "</td>\r\n" + //
                //         "                </tr>\r\n";
            }
            // getWriter 전에 charset 하기
            response.setContentType("text/html;charset=UTF-8"); // 클라이언트한테 보여지는 화면의 한글이 깨지는걸 방지해줌. getWriter 전에 charset
                                                                // 해줘야 함.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}