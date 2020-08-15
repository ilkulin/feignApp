package com.practice.server.service;

import com.practice.server.context.ContextHolder;

public class ClientService {

    private ContextHolder contextHolder;

    public ClientService() {
        contextHolder = ContextHolder.getInstance();
    }

    public boolean isClientValid(String name) {
        return contextHolder.containsClient(name);
    }
}
