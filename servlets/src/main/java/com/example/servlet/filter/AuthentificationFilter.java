package com.example.servlet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(filterName = "auth", urlPatterns = {"/admin", "/products"})
public class AuthentificationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpSession session = req.getSession();

        if (session == null) {
            res.sendError(401);
            return;
            // chain.doFilter(req,res);
        }

        final String username = (String) session.getAttribute("username");

        if (username == null || !username.equals(getServletContext().getInitParameter("username"))) {
            res.sendError(401);
            return;

        }
        chain.doFilter(req,res);
    }
}
