package com.practice.client.errorhandler;

import feign.Response;
import feign.codec.ErrorDecoder;

import static java.util.Objects.nonNull;

public class DefaultErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String body = nonNull(response.body())
                ? response.body().toString()
                : "";
        return new ResponseException(body);
    }
}
