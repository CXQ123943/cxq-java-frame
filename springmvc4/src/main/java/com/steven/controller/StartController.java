package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
public class StartController {

    @RequestMapping("/api/start/start")
    public String start() {
        System.out.println("start(): success...");
        return "success";
    }

}
