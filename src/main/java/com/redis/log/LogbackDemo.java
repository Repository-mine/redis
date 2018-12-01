package com.redis.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    private static Logger logger = LoggerFactory.getLogger(com.redis.log.LogbackDemo.class);
    public static void main(String[] args) {

        logger.trace("======trace");
        logger.debug("======debug");
        logger.info("======info");
        logger.warn("======warn");
        logger.error("======error");

        String name = "Aub";
        String message = "3Q";
        String[] fruits = {"apple", "banana","orange"};

        // logback提供的可以使用变量的打印方式，结果为"Hello,Aub!"
        logger.info("Hello,{}!", name);
        // 可以有多个参数,结果为“Hello,Aub! 3Q!”
        logger.info("Hello,{}!   {}!", name, message);
        // 可以传入一个数组，结果为"Fruit: apple,banana"
        logger.info("Fruit:  {},{},{}", fruits);

        System.out.println("hello world ");
    }

}