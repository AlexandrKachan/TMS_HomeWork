package com.example.servlet.servlet;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/addProduct")
public class AddProduct extends HttpServlet {

    private ProductRepository productRepository = ProductRepository.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-product.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ProductEntity productEntity = new ProductEntity(req.getParameter("title"), Double.parseDouble(req.getParameter("price")));
        //  productEntity.addProduct(productEntity);
        productRepository.addProduct(productEntity);

        resp.sendRedirect("catalog");
    }
}