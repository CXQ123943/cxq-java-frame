package com.steven.springboot2.servlet.fiter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CXQ
 * @version 1.0
 */
public class BeanFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("BeanFilter init()...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("BeanFilter doFilter(): " + req.getRequestURI());
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("BeanFilter destroy()...");
    }

}