package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.controlls.commons.Commons;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Commons commons = new Commons();
            String uniqueID = commons.generateUUID();
            
            String name = request.getParameter("name");

            OptionInforsDao optionInforsDao = new OptionInforsDao();
            int count = optionInforsDao.InsertName(name);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            String contents ="Insert count : "+count;
           printWriter.println(contents);
           printWriter.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    
}
