package com.practice.server.filter;

import com.practice.server.service.ClientService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthClientFilter implements Filter {

    private ClientService clientService;

    @Override
    public void init(FilterConfig filterConfig) {
        clientService = new ClientService();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String client = ((HttpServletRequest) request).getHeader("Client");
        if (!clientService.isClientValid(client)) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //empty
    }
}
