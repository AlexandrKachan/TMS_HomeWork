package com.example.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private String username;
    private String password;


    @Override
    public void init() {
        username= getServletContext().getInitParameter("username");
        password = getServletContext().getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        final String hiddenInput = (String) req.getAttribute("hiddenInput");
//        System.out.println(hiddenInput);

        // final String login = (String) req.getAttribute("login");
        // final String pass = (String) req.getAttribute("pass");
        String login =  req.getParameter("login");
        String pass =  req.getParameter("pass");
        System.out.println(pass);
        System.out.println(login);


        if (login == null||pass==null){
            resp.sendError(401);
            return;
        }

        if (!login.equals(username)||!pass.equals(password)){
            System.out.println("Password is not correct");
            resp.sendError(401);
            return;
        }
        final HttpSession session = req.getSession(true);
        session.setAttribute("username",login);



        resp.sendRedirect("catalog");
    }
}