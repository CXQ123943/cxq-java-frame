package com.steven.controller;

import com.steven.pojo.User;
import com.steven.vo.UserVo;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("/api/param")
@Controller
public class ParamController {

    @RequestMapping("request-header")
    public String requestHeader(@RequestHeader(value = "host") String host) {
        System.out.println(host);
        return "success";
    }

    @RequestMapping("cookie")
    public String cookieValue(@CookieValue("name") String value) {
        System.out.println(value);
        return "success";
    }

    @RequestMapping("rest/{id}/{age}")
    public String pathVariable(
            @PathVariable("id") Integer id,
            @PathVariable("age") Integer age) {
        System.out.println(id);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("key-value")
    public String requestParam(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "age", required = false, defaultValue = "18") int age,
            Boolean gender, User user,
            Integer[] ids,
            UserVo userVo01, UserVo userVo02) {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        System.out.println("userA: " + user);
        System.out.println("ids: " + Arrays.toString(ids));
        System.out.println("userVoA: " + userVo01);
        System.out.println("userVoB: " + userVo02);
        return "success";
    }


}
