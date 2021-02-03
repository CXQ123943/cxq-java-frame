package com.steven.springboot2.servlet.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CXQ
 * @version 1.0
 */
@Configuration
public class BeanListenerConfig {

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new BeanListener());
    }
}
