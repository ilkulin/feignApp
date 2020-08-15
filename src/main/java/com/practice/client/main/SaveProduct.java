package com.practice.client.main;

import com.practice.client.ProductClient;
import com.practice.client.builder.ProductClientBuilder;
import com.practice.client.errorhandler.ResponseException;
import com.practice.client.interceptor.ClientAuthInterceptor;
import com.practice.server.entity.Product;

import java.time.LocalDate;
import java.util.List;

public class SaveProduct {

    public static void main(String[] args) {
        try {
            ProductClientBuilder clientBuilder = new ProductClientBuilder();
            ProductClient testClient = clientBuilder.buildProductClient(List.of(new ClientAuthInterceptor()));
            Product product = new Product("", 12, LocalDate.now().plusYears(1));
            testClient.saveProduct(product);
        } catch (ResponseException e) {
            System.out.println(e.getMessage());
        }
    }
}
