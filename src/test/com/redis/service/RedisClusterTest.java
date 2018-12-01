package com.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class RedisClusterTest {
    @Autowired
    private RedisService redisService;

    @Resource(name = "jedisCluster")
    private JedisCluster jedisCluster;

    @Test
    public void testNotNull() {
//        redisService.set("hello", "world");
        System.out.println(redisService.get("hello"));
//        redisService.set("java", "best");
    }

    @Test
    public void testJedisCluster() {

        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
//        for (Map.Entry<String, JedisPool> entry : clusterNodes.entrySet()) {
//            Jedis jedis = entry.getValue().getResource();
//            String s = jedis.clusterInfo();
//            System.out.println(s);
//        }
    }
}