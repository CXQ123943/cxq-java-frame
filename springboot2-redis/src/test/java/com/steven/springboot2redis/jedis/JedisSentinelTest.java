package com.steven.springboot2redis.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CXQ
 * @version 1.0
 */
class JedisSentinelTest {

    private JedisPoolConfig jedisPoolConf;

    private void init() {
        jedisPoolConf = new JedisPoolConfig();
        jedisPoolConf.setMaxTotal(14);
        jedisPoolConf.setMaxWaitMillis(1000L);
        jedisPoolConf.setMaxIdle(20);
        jedisPoolConf.setMinIdle(0);
    }

    @Test
    void jedisSentinel() {
        init();
        Set<String> sentinels = new HashSet<>(3);
        sentinels.add("127.0.0.1:27007");
        sentinels.add("127.0.0.1:27008");
        sentinels.add("127.0.0.1:27009");

        try (JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("my-master", sentinels, jedisPoolConf);
             Jedis jedis = jedisSentinelPool.getResource()) {

            if (!"PONG".equals(jedis.ping())) {
                throw new RuntimeException("ping error...");
            }

            jedis.set("sentinel-key", "sentinel-val");
            System.out.println(jedis.get("sentinel-key"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
