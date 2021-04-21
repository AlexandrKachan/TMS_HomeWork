package com.example.servlet.servlet;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "catalog", urlPatterns = "/catalog")

public class CatalogServlet extends HttpServlet {

    private ProductRepository productRepository = ProductRepository.getINSTANCE();

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<ProductEntity> products = productRepository.getProducts();
        request.setAttribute("products", products);
        final ServletContext servletContext = getServletContext();
        servletContext.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request, response);


    }
}
