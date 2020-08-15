package com.practice.client.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.practice.client.serializer.LocalDateSerializer;

public class LocalDateEncoderlModule extends SimpleModule {

    public LocalDateEncoderlModule() {
        super();
        addSerializer(new LocalDateSerializer());
    }
}
