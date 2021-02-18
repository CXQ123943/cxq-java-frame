package com.steven.springboot2.activemq.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class ProducerA {
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    public ProducerA(JmsMessagingTemplate jmsMessagingTemplate) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
    }

    public void sendToQueue(String destination, final Object message) {
        Destination dest = new ActiveMQQueue(destination);
        jmsMessagingTemplate.convertAndSend(dest, message);
    }
}
