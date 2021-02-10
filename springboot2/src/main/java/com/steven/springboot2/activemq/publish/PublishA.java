package com.steven.springboot2.activemq.publish;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class PublishA {
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    public PublishA(JmsMessagingTemplate jmsMessagingTemplate) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
    }

    public void sendToTopic(String topicName, final Object message) {
        Destination dest = new ActiveMQTopic(topicName);
        jmsMessagingTemplate.convertAndSend(dest, message);
    }
}
