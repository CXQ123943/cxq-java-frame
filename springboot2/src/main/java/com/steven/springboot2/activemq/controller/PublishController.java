package com.steven.springboot2.activemq.controller;

import com.steven.springboot2.activemq.publish.PublishA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/publish")
public class PublishController {

    private PublishA publishA;

    @Autowired
    public PublishController(PublishA publishA) {
        this.publishA = publishA;
    }

    @RequestMapping("send-to-topic")
    public Object sendToTopic(String msg) throws InterruptedException {
        for (int i = 0, j = 10; i < j; i++) {
            TimeUnit.SECONDS.sleep(1L);
            publishA.sendToTopic("start.topic", msg + "-" + i);
        }
        return "sendToTopic() success";
    }

}
