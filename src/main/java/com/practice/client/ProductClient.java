package com.practice.client;

import com.practice.server.entity.Product;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ProductClient {

    @RequestLine("GET ?name={productName}")
    @Headers({"Client: Feign"})
    public Product getProduct(@Param("productName") String productName);

    @RequestLine("POST")
    public Product saveProduct(Product product);
}
