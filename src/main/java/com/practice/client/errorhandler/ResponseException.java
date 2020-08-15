package com.practice.client.errorhandler;

public class ResponseException extends RuntimeException {

    public ResponseException(String message) {
        super(message);
    }
}
