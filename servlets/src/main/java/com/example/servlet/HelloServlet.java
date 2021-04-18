package com.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import  java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init(ServletConfig servletConfig) {
        System.out.printf("Servlet init");
        message = servletConfig.getServletContext().getInitParameter("name");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", Arrays.asList("Phone", "Laptop"," TV"));
        //request.getSession().setAttribute("product", Arrays.asList("Phone", "Laptop"," TV"));
        System.out.printf("Redirect");
        //response.sendRedirect("index.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
        System.out.printf("Servlet destroy");
    }
}