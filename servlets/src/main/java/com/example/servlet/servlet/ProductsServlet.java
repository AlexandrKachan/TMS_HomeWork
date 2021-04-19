package com.example.servlet.servlet;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepositoty;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    private ProductRepositoty productRepositoty= ProductRepositoty.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-product.jsp").forward(req, resp); // возвращает страницу
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ProductEntity productEntity = new ProductEntity(req.getParameter("Title"), Double.parseDouble(req.getParameter("Prise")));
        productRepositoty.addProduct(productEntity);
        resp.sendRedirect("catalog");
    }
}
