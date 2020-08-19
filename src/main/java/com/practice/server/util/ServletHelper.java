package com.practice.server.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ServletHelper {

    private Gson gson;

    private ServletHelper() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    public String getBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        String myresult = "";
        String line;
        while ((line = reader.readLine()) != null) {
            myresult += line;
    }
        return myresult;
    }

    public void sendJsonResponse(HttpServletResponse response, Object dto, int status) throws IOException {
        String jsonResponse = gson.toJson(dto);
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        writer.print(jsonResponse);
        writer.flush();
    }

    public static ServletHelper getInstance() {
        return ServletHelper.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final ServletHelper INSTANCE = new ServletHelper();
    }
}
