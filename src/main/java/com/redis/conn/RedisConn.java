package com.redis.conn;

import redis.clients.jedis.Jedis;

public class RedisConn {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("119.29.8.119", 6379);
        String s = jedis.set("hhh", "oo");
        System.out.println(s);
        System.out.println(jedis.get("hh"));
    }
}
