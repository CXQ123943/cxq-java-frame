package com.steven.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("api/rest-template")
public class RestTemplateController {

    @ResponseBody
    @GetMapping("get-mapping")
    public String getMapping(String name) {
        return "getMapping(): " + name;
    }

    @ResponseBody
    @PostMapping("post-mapping")
    public String postMapping(String name) {
        return "postMapping(): " + name;
    }

    @RequestMapping("redirect")
    public String redirect(String name) {
        System.out.println("redirect()..." + name);
        return "redirect:/success.html";
    }
}
