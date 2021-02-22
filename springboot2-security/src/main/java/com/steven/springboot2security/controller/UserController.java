package com.steven.springboot2security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("login-routing")
    public String loginRouting() {
        System.out.println("loginRouting()...");
        return "login";
    }

    @RequestMapping("main-routing")
    public String mainRouting() {
        System.out.println("mainRouting()...");
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "main";
    }

    @RequestMapping("logout")
    public void logout() {
        System.out.println("注销登录成功...");
    }
}