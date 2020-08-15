package com.practice.server.controlller.rest;

import com.practice.server.util.ErrorProps;
import com.practice.server.util.ResponseHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthErrorHandler extends HttpServlet {

    private ResponseHelper responseHelper;

    public AuthErrorHandler() {
        responseHelper = ResponseHelper.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int status = response.getStatus();
        ErrorProps errorProps = new ErrorProps(status, "Client is not authenticated");
        responseHelper.sendJsonResponse(response, errorProps, status);
    }
}
