package com.redis.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

@Service
public class RedisClusterServiceImpl implements RedisService {

    @Resource(name = "jedisCluster")
    private JedisCluster jedisCluster;

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

//    public void setJedisCluster(JedisCluster jedisCluster) {
//        this.jedisCluster = jedisCluster;
//    }
}
