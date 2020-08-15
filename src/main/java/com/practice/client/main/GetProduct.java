package com.practice.client.main;

import com.practice.client.ProductClient;
import com.practice.client.builder.ProductClientBuilder;
import com.practice.client.errorhandler.ResponseException;

public class GetProduct {

    public static void main(String[] args) {
        try {
            ProductClientBuilder clientBuilder = new ProductClientBuilder();
            ProductClient testClient = clientBuilder.buildProductClient();
            testClient.getProduct("default");
        } catch (ResponseException e) {
            System.out.println(e.getMessage());
        }
    }
}
