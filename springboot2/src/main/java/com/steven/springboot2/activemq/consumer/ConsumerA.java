package com.steven.springboot2.activemq.consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class ConsumerA {

    @JmsListener(destination = "start.queue")
    public void spendFromQueue(ActiveMQTextMessage message) {
        try {
            System.out.println("ConsumerA 消费了队列中的" + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
