package com.practice.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ClientAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Client", "Feign");
    }
}
