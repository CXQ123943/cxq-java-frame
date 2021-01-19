package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("/api/i18n")
public class I18nController {

    @RequestMapping("test")
    public String test() {
        return "forward:/view/i18n.jsp";
    }
}
