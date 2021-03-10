package com.steven.springboot2redis.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author CXQ
 * @version 1.0
 */
class SlowLogTest {
    private JedisPoolConfig jedisPoolConf;

    private void init() {
        jedisPoolConf = new JedisPoolConfig();
        jedisPoolConf.setMaxTotal(10);
        jedisPoolConf.setMaxWaitMillis(1000L);
        jedisPoolConf.setMaxIdle(20);
        jedisPoolConf.setMinIdle(0);
    }

    @Test
    void test() {
        init();
        try (JedisPool jedisPool = new JedisPool(jedisPoolConf, "127.0.0.1", 6380, 10000, "steven");
             Jedis jedis = jedisPool.getResource()){

            if (!"PONG".equals(jedis.ping())) {
                System.out.println("jedis ping error...");
            }

            System.out.println("slowlog get: " + jedis.slowlogGet(2));
            System.out.println("slowlog len: " + jedis.slowlogLen());
            System.out.println("slowlog reset: " + jedis.slowlogReset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
