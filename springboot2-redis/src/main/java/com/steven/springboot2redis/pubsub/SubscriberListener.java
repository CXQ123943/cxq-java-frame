package com.steven.springboot2redis.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * @author CXQ
 * @version 1.0
 */
public class SubscriberListener extends JedisPubSub {

    private String subscriberName;

    public SubscriberListener(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.printf("onMessage(): %s get message '%s' from channel %s\n", subscriberName, message, channel);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.printf("onSubscribe(): %s subscribe channel %s-%d\n", subscriberName, channel, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.printf("onUnsubscribe(): %s unsubscribe channel %s-%d\n", subscriberName, channel, subscribedChannels);
    }
}
