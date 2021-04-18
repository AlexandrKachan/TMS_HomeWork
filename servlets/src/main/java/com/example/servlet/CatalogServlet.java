package com.example.servlet;

import com.example.servlet.repository.ProductRepositoty;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "catalog", urlPatterns = "/catalog")

public class CatalogServlet extends HttpServlet {

    private ProductRepositoty productRepositoty = new ProductRepositoty();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productRepositoty.getProducts());
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);



    }
}
