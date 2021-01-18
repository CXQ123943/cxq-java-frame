package com.steven.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
@ControllerAdvice
public class ExceptionUtil {

    @ResponseBody
    @ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
    public String exceptionHandler(Exception e) {
        System.out.println("ExceptionUtil.exceptionHandler()..." + e);
        return "err";
    }
}
