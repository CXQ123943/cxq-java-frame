package com.steven.springboot2security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.steven.springboot2security.mapper")
public class Springboot2SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2SecurityApplication.class, args);
    }

}
