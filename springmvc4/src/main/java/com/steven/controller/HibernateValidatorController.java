package com.steven.controller;

import com.steven.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/valid/")
@Controller
public class HibernateValidatorController {

    @ResponseBody
    @RequestMapping("hibernate-validator")
    public String hibernateValid(@Valid Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("爆发了" + result.getErrorCount() + "个异常！");
            for (ObjectError e : result.getAllErrors()) {
                System.out.println("爆发异常的对象为：" + e.getObjectName());
                System.out.println("具体异常的内容为：" + e.getDefaultMessage());
            }
        }
        System.out.println(teacher);
        return "ok";
    }
}