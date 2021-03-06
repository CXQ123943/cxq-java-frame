package com.steven.springboot2.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CXQ
 * @version 1.0
 */
@Configuration
public class BeanServletConfig {

    @SuppressWarnings("all")
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new BeanServlet(), "/api/servlet/bean");
    }
}
