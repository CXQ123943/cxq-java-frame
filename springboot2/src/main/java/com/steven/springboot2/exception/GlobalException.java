package com.steven.springboot2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exception(Exception e) {
        System.out.println("GlobalException.exception()");
        Map<String, Object> exceptionMsg = new HashMap<>(2);
        exceptionMsg.put("statusCode", 500);
        exceptionMsg.put("message", e.getMessage());
        return exceptionMsg;
    }
}