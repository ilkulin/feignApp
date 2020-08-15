package com.practice.client.builder;

import com.practice.client.ProductClient;
import com.practice.client.errorhandler.DefaultErrorDecoder;
import com.practice.client.module.LocalDateDecoderModule;
import com.practice.client.module.LocalDateEncoderlModule;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.Collections;
import java.util.List;

public class ProductClientBuilder {

    public ProductClient buildProductClient() {
        return buildProductClient(Collections.EMPTY_LIST);
    }

    public ProductClient buildProductClient(List<RequestInterceptor> requestInterceptors) {
        return Feign.builder()
                .errorDecoder(new DefaultErrorDecoder())
                .encoder(new JacksonEncoder(List.of(new LocalDateEncoderlModule())))
                .decoder(new JacksonDecoder(List.of(new LocalDateDecoderModule())))
                .requestInterceptors(requestInterceptors)
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(new ProductTarget());
    }

    private static class ProductTarget implements Target<ProductClient> {

        @Override
        public String url() {
            return "http://localhost:8090/feignapp/product";
        }

        @Override
        public Class<ProductClient> type() {
            return ProductClient.class;
        }

        @Override
        public Request apply(RequestTemplate input) {
            input.target(url());
            return input.request();
        }

        @Override
        public String name() {
            return ProductClient.class.getSimpleName();
        }
    }
}
