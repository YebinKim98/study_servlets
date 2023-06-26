package com.example.study_servlets.daos.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*") //모든것! 어느 서블렛이든 무조건 이 필터를 거쳐서 가게됨 
public class SimpleFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                try {
                    System.out.println(request.getRemoteAddr());
                    System.out.println(request.getRemoteAddr());

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
                    requestDispatcher.forward(request, response);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
    }
    
}
