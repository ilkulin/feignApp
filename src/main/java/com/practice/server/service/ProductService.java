package com.practice.server.service;

import com.practice.server.context.ContextHolder;
import com.practice.server.entity.Product;

import static java.util.Objects.nonNull;

public class ProductService {

    private ContextHolder contextHolder;

    public ProductService() {
        System.out.println("Creating new product service");
        contextHolder = ContextHolder.getInstance();
    }

    public Product getProductById(String name) {
        return contextHolder.getProductByName(name);
    }

    public boolean saveProduct(Product product) {
        boolean result = false;
        if (nonNull(product) && nonNull(product.getName()) && !product.getName().isBlank()) {
            contextHolder.saveProduct(product);
            result = true;
        }
        return result;
    }
}
