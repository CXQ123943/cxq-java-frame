package com.steven.springboot2redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

/**
 * @author CXQ
 * @version 1.0
 */
public class SubscriberB {
    private static JedisPoolConfig jedisPoolConfig;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxWaitMillis(10000L);
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setMinIdle(0);
    }

    public static void main(String[] args) {
        try (JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6380, 10000, "123");
             Jedis jedis = jedisPool.getResource()) {

            if (!"PONG".equals(jedis.ping())) {
                throw new RuntimeException("ping error...");
            }

            System.out.println("channels: " + jedis.pubsubChannels("*"));
            System.out.println("subscribers: " + jedis.pubsubNumSub("sina"));
            JedisPubSub jedisPubSub = new SubscriberListener("sub-b");
            jedisPubSub.onUnsubscribe("sohu", 1);
            jedis.subscribe(jedisPubSub, "sohu", "sina");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
