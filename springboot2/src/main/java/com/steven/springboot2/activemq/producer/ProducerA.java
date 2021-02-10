package com.steven.springboot2.activemq.producer;

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

    public void sendToQueue(Destination destination, final Object message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
