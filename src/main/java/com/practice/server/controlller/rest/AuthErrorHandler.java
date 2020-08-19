package com.practice.server.controlller.rest;

import com.practice.server.util.ErrorProps;
import com.practice.server.util.ServletHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthErrorHandler extends HttpServlet {

    private ServletHelper servletHelper;

    public AuthErrorHandler() {
        servletHelper = ServletHelper.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int status = response.getStatus();
        ErrorProps errorProps = new ErrorProps(status, "Client is not authorized");
        servletHelper.sendJsonResponse(response, errorProps, status);
    }
}
