package com.steven.springboot2redis.jedis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
class JedisConfigTest {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisCluster jedisCluster;


    @Test
    void jedispool() {
        try (Jedis jedis = jedisPool.getResource()){
            jedis.setex("name", 5, "100");
            System.out.println(jedis.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void jedisCluster() {
        try {
            jedisCluster.setex("name", 5, "100");
            System.out.println(jedisCluster.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
