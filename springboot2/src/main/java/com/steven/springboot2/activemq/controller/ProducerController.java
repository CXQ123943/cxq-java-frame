package com.steven.springboot2.activemq.controller;

import com.steven.springboot2.activemq.producer.ProducerA;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.concurrent.TimeUnit;

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
    public Object sendToQueue(String msg) throws InterruptedException {
        for (int i = 0, j = 10; i < j; i++) {
            TimeUnit.SECONDS.sleep(1L);
            producerA.sendToQueue("start.queue", msg + "-" + i);
        }
        return "sendToQueue() success";
    }
}
