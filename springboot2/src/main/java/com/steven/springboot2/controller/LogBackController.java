package com.steven.springboot2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/logback")
public class LogBackController {

    private Logger logger = LoggerFactory.getLogger(LogBackController.class);

    @RequestMapping("test")
    public String test() {
        logger.debug("DEBUG级别信息...");
        logger.info("INFO级别信息...");
        logger.warn("WARN级别信息...");
        logger.error("ERROR级别信息...");
        return "success";
    }
}
