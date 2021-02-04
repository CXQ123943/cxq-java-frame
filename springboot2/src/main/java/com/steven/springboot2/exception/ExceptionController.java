package com.steven.springboot2.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @RequestMapping("/execute")
    public String execute(Integer meta) {
        if (meta == 0) {
            throw new RuntimeException("runtimeException");
        }
        return "success";
    }
}
