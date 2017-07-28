package com.oracle.qlu.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisConnSingle {
	@Test
	public void test(){
		String redisAddress = "192.168.126.130";
		int redisPort = 6379; 
		int redisTimeout = 2000; 
		Jedis jedis = new Jedis(redisAddress,redisPort,redisTimeout);//设置链接
		jedis.set("name","绪鑫");//存入数据
		String name = jedis.get("name");//取出数据
		System.out.println(name);
		jedis.close();//释放资源
	}
}
