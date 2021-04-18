package com.example.servlet.repository;

import com.example.servlet.entity.ProductEntity;

import java.util.Arrays;
import java.util.List;

public class ProductRepositoty {
    public List<ProductEntity> getProducts() {
        return Arrays.asList(
                new ProductEntity("Товар 1", 12),
                new ProductEntity("Товар 2", 10),
                new ProductEntity("Товар 3", 15),
                new ProductEntity("Товар 4", 18),
                new ProductEntity("Товар 5", 19),
                new ProductEntity("Товар 7", 11)
                );
    }

}
