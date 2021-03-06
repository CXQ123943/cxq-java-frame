package com.steven.springboot2redis.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

/**
 * @author CXQ
 * @version 1.0
 */
class PipelineTest {

    private JedisPoolConfig jedisPoolConf;

    private void init() {
        jedisPoolConf = new JedisPoolConfig();
        jedisPoolConf.setMaxTotal(15);
        jedisPoolConf.setMaxWaitMillis(1000L);
        jedisPoolConf.setMaxIdle(20);
        jedisPoolConf.setMinIdle(0);
    }

    @Test
    void noPipeline() {
        init();
        try (JedisPool jedisPool = new JedisPool(jedisPoolConf, "127.0.0.1", 6380, 10000, "steven");
             Jedis jedis = jedisPool.getResource()) {

            if (!"PONG".equals(jedis.ping())) {
                throw new RuntimeException("ping error...");
            }

            long startTime = System.currentTimeMillis();
            // no pipeline
            // total spend = 10000 * (netTime) + 10000 * (commandTime)
            // carry 1 command per send
            for (int i = 0; i < 10000; i++) {
                jedis.hset("key" + i, "field" + i, "value" + i);
            }
            System.out.println("hset with no pipeline done: " + (System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void pipeline() {
        init();
        try (JedisPool jedisPool = new JedisPool(jedisPoolConf, "127.0.0.1", 6380, 10000, "steven");
             Jedis jedis = jedisPool.getResource()) {

            if (!"PONG".equals(jedis.ping())) {
                throw new RuntimeException("ping error...");
            }

            long startTime = System.currentTimeMillis();
            // pipeline
            // total spend = 100 * (netTime) + 100 * (commandTime)
            // carry 100 command per send
            for (int i = 0; i < 100; i++) {
                Pipeline pipeline = jedis.pipelined();
                // 0-99, 100-199, 200-299...
                for (int j = i * 100; j < (i + 1) * 100; j++) {
                    pipeline.hset("key" + i, "field" + i, "value" + i);
                }
                pipeline.syncAndReturnAll();
            }
            System.out.println("hset with no pipeline done: " + (System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
