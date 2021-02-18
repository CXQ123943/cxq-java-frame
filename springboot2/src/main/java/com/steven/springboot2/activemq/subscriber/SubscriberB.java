package com.steven.springboot2.activemq.subscriber;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class SubscriberB {

    @JmsListener(destination = "start.topic", containerFactory = "jmsListenerContainerFactory")
    public void spendFromTopic(ActiveMQTextMessage message) {
        try {
            System.out.println("SubscriberB spend" + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
