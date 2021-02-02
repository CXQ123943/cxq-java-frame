package com.steven.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("api/thymeleaf")
public class ThymeleafController {
    @RequestMapping("test")
    public String test(Map<String, Object> map, String name) {
        map.put("message", name);
        return "main";
    }
}
