package com.practice.client.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.practice.client.serializer.LocalDateDesirializer;

import java.time.LocalDate;

public class LocalDateDecoderModule extends SimpleModule {

    public LocalDateDecoderModule() {
        super();
        addDeserializer(LocalDate.class, new LocalDateDesirializer());
    }
}
