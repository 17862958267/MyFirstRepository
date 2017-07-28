package com.oracle.qlu.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPool {
	@Test
	public void test(){
		//创建池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMinIdle(10);
		//获得连接池
		 redis.clients.jedis.JedisPool pool = new redis.clients.jedis.JedisPool(config, "192.168.126.130", 6379);
		 //获得核心对象
		 Jedis jedis = null;
		 try{
		 jedis = pool.getResource();
		 //设置数据
		 jedis.set("name","xuxin");
		 String name = jedis.get("name");
		 System.out.println(name);
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 if(jedis!=null)jedis.close();
			 if(pool!=null)pool.close();
		 }
	}

}
