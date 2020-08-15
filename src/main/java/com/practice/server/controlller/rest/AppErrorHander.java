package com.practice.server.controlller.rest;

import com.practice.server.util.ErrorProps;
import com.practice.server.util.ResponseHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

public class AppErrorHander extends HttpServlet {

    private ResponseHelper responseHelper;

    public AppErrorHander() {
        responseHelper = ResponseHelper.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int status = response.getStatus();
        String exceptionMessage = (String) request.getAttribute("javax.servlet.error.message");
        ErrorProps errorProps = new ErrorProps(status, exceptionMessage);
        responseHelper.sendJsonResponse(response, errorProps, status);
    }
}
