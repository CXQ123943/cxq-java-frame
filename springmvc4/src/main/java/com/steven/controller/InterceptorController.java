package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/interceptor")
@Controller
public class InterceptorController {

    @ResponseBody
    @RequestMapping("test")
    public String test() {
        System.out.println("test()...");
        return "ok";
    }
}
