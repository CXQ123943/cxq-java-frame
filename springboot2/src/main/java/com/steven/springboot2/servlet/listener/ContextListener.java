package com.steven.springboot2.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author CXQ
 * @version 1.0
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener contextInitialized()...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener contextDestroyed()...");
    }
}