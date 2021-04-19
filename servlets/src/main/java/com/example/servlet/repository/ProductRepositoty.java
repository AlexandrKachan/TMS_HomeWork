package com.example.servlet.repository;

import com.example.servlet.entity.ProductEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoty {

    private static final ProductRepositoty INSTANCE = new ProductRepositoty();


    private List<ProductEntity> products = new ArrayList<>();


    private ProductRepositoty() {
        products.add(new ProductEntity("Товар 1", 12));
        products.add(new ProductEntity("Товар 2", 10));
        products.add(new ProductEntity("Товар 3", 15));
        products.add(new ProductEntity("Товар 4", 18));
        products.add(new ProductEntity("Товар 5", 19));
        products.add(new ProductEntity("Товар 7", 11));
    }

    public static ProductRepositoty getINSTANCE() {
        return INSTANCE;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void addProduct(ProductEntity productEntity) {
        products.add(productEntity);

    }
}
