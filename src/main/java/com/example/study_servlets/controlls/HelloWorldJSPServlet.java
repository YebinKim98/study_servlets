package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
<<<<<<< HEAD

=======
>>>>>>> e94f80b0e3c664ce294146b7dd8314b2bbea287f
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String contents = "yebinhyowon !";
            
            request.setAttribute("contents", contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
