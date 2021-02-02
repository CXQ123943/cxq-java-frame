package com.steven.springboot2.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author CXQ
 * @version 1.0
 */
class ShieldTest {

    @Test
    void shield() {
        String baseUrl = "http://127.0.0.1:8080/api/shield/test?word=a-blue-apple";
        System.out.println(new RestTemplate().getForObject(baseUrl, String.class));
    }
}
