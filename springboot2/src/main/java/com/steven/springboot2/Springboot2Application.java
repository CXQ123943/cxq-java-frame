package com.steven.springboot2;

import com.steven.springboot2.servlet.ContextServlet;
import com.steven.springboot2.servlet.fiter.ContextFilter;
import com.steven.springboot2.servlet.listener.ContextListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.steven.springboot2.mapper")
@ServletComponentScan("com.steven.springboot2.servlet")
public class Springboot2Application implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("contextServlet", new ContextServlet()).addMapping("/api/servlet/context-servlet");
        servletContext.addFilter("contextFilter", new ContextFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true,
                        "/api/servlet/*");

        servletContext.addListener(new ContextListener());
    }
}


/*@SpringBootApplication
@MapperScan("com.steven.springboot2.mapper")
public class Springboot2Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Springboot2Application.class);
    }
}*/

