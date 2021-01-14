package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/result-mapping")
@Controller
public class RequestMappingController {

    @RequestMapping({"test1", "test2", "test3"})
    public String test() {
        System.out.println("test()...");
        return "success";
    }

    @RequestMapping("/?/one")
    public String one() {
        System.out.println("one...");
        return "success";
    }

    @RequestMapping("/*/two")
    public String two() {
        System.out.println("two...");
        return "success";
    }

    @RequestMapping("/**/three")
    public String three() {
        System.out.println("three...");
        return "success";
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public String method() {
        System.out.println("method()...");
        return "success";
    }

    @RequestMapping(value = "/params", params = {"!name", "age=18", "gender!=1"})
    public String params() {
        System.out.println("params()...");
        return "success";
    }
}
