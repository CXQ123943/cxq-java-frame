package com.steven.springboot2.activemq.controller;

import com.steven.springboot2.activemq.producer.ProducerA;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/producer")
public class ProducerController {

    private ProducerA producerA;

    @Autowired
    public ProducerController(ProducerA producerA) {
        this.producerA = producerA;
    }

    @RequestMapping("send-to-queue")
    public Object sendToQueue(String message) {
        Destination dest = new ActiveMQQueue("start.queue");
        producerA.sendToQueue(dest, message);
         return "success";
    }
}
