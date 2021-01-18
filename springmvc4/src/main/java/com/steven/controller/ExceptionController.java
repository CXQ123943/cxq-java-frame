package com.steven.controller;

import com.steven.util.MyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/exception")
@Controller
public class ExceptionController {

    @ResponseBody
    @RequestMapping("exception-handler-test")
    public String exceptionHandlerTest(Integer num) {
        System.out.println("test()...");
        System.out.println(1 / num);
        int[] arr = {1, 2};
        System.out.println(arr[num]);
        return "ok";
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public String exceptionHandler(Exception e) {
        System.out.println("ExceptionController.exceptionHandler()..." + e);
        return "error";
    }

    @RequestMapping("response-status")
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ExceptionController: 页面走丢了！")
    public void responseStatus() {
        System.out.println("responseStatus()...");
    }

    @ResponseBody
    @RequestMapping("my-not-found-exception-test")
    public String myNotFoundExceptionTest(Integer num) throws MyNotFoundException {
        System.out.println("myNotFoundExceptionTest()...");
        if(num == 0){
            throw new MyNotFoundException();
        }
        return "success";
    }
}
