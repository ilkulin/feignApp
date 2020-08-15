package com.practice.server.context;

import com.practice.server.entity.Product;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContextHolder {

    private Map<String, Product> products;
    private Set<String> clients;

    private ContextHolder() {
        products = new HashMap<>();
        Product defaultProduct = new Product("default", 100, LocalDate.now());
        saveProduct(defaultProduct);
        clients = new HashSet<>();
        clients.add("Feign");
    }

    public Product getProductByName(String name) {
        return products.get(name);
    }

    public boolean containsClient(String name) {
        return clients.contains(name);
    }

    public void saveProduct(Product product) {
        products.put(product.getName(), product);
    }

    public static ContextHolder getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final ContextHolder INSTANCE = new ContextHolder();
    }
}
