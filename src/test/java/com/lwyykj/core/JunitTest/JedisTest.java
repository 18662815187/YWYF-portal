package com.lwyykj.core.JunitTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	/** 
     * 单机版测试 
     */  
    @SuppressWarnings("resource")
	public static void testSpringJedisSingle() {  
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");  
        JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");  
        Jedis jedis = pool.getResource();  
        jedis.set("lanlan", "piaopiao");  
        String string = jedis.get("lanlan");  
        System.out.println(string);  
        jedis.close();  
        pool.close();  
    }  
      
    public static void main(String[] args) {  
        testSpringJedisSingle();  
    }  
}  
