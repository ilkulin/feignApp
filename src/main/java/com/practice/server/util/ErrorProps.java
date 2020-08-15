package com.practice.server.util;

public class ErrorProps {

    private String status;
    private String message;

    public ErrorProps(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorProps(int status, String message) {
        this.status = String.valueOf(status);
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
