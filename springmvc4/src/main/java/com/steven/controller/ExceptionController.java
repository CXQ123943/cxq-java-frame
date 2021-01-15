package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/exception")
@Controller
public class ExceptionController {

    @RequestMapping("test")
    @ResponseBody
    public String test(Integer num) {
        System.out.println(1 / num);
        return "ok";
    }

    @ResponseBody
    @ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
    public String exceptionHandler(Exception e) {
        System.out.println("exceptionHandler()...");
        e.printStackTrace();
        return "error";
    }
}
