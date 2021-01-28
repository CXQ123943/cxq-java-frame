package com.steven.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/start")
public class StartController {

    @RequestMapping("test")
    public String start() {
        System.out.println("测试");
        return "测试：test()...";
    }
}
