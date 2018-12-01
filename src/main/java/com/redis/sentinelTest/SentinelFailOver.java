package com.redis.sentinelTest;

import com.redis.conn.RedisConn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SentinelFailOver {
    private static Logger logger = LoggerFactory.getLogger(RedisConn.class);

    public static void main(String[] args) {

        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<>();
        sentinels.add("119.29.8.119:26379");
        sentinels.add("119.29.8.119:26380");
        sentinels.add("119.29.8.119:26381");
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels);
        Random random = new Random();
        while (true) {
            Jedis jedis = null;
            try {
                int index = random.nextInt(100000);
                jedis = jedisSentinelPool.getResource();
                String key = "k-" + index;
                String value = "v-" + index;
                jedis.set(key, value);
                logger.info("{} value is {}", key, jedis.get(key));
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }
}
