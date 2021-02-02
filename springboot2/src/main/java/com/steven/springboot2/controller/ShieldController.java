package com.steven.springboot2.controller;

import com.steven.shieldspringbootstarter.ShieldOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/shield")
public class ShieldController {

    private ShieldOperations shieldOperations;

    @Autowired
    public ShieldController(ShieldOperations shieldOperations) {
        this.shieldOperations = shieldOperations;
    }

    @RequestMapping("test")
    public String test(String words) {
        return shieldOperations.shield(words);
    }
}
