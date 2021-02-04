package com.steven.springboot2.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("/api/aop")
public class AopController {

    @RequestMapping("execute")
    public String execute(Integer meta) {
        if (meta == 0) {
            throw new RuntimeException("execute() exception...");
        }
        System.out.println("execute()...");
        return "success";
    }
}
