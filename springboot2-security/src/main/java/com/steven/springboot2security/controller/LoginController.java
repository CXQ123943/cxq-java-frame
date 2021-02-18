package com.steven.springboot2security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        System.out.println("login()...");
        return "login";
    }
    
    @RequestMapping("login-success")
    public String loginSuccess() {
        System.out.println("loginSuccess()...");
        return "main";
    }
}