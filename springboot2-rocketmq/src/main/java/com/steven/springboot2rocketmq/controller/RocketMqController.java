package com.steven.springboot2rocketmq.controller;

import com.steven.springboot2rocketmq.producer.ProducerA;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/rocketmq")
public class RocketMqController {

    private ProducerA producer;

    @Autowired
    public RocketMqController(ProducerA producer) {
        this.producer = producer;
    }

    @RequestMapping("send")
    public String send(String topic, String tag, String msg) throws Exception {
        SendResult sendResult = producer.getProducer().send(new Message(topic, tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET)));
        System.out.println("msgId: " + sendResult.getMsgId());
        System.out.println("sendStatus: " + sendResult.getSendStatus());
        return "success";
    }
}
