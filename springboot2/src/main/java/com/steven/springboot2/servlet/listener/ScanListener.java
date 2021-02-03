package com.steven.springboot2.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author CXQ
 * @version 1.0
 */
@WebListener("/api/servlet/*")
public class ScanListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ScanListener contextInitialized()... ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ScanListener contextDestroyed()... ");
    }
}
