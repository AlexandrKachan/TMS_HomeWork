package com.example.servlet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "aut", urlPatterns = {"/admin", "/product", "/remove", "/change"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session == null) {
            res.sendError(401);
            return;
        }
        String username = (String) session.getAttribute("username");
        if (username == null || !username.equalsIgnoreCase(getServletContext().getInitParameter("username"))) {
            res.sendError(401);
            return;
        }
        chain.doFilter(req, res);


    }
}