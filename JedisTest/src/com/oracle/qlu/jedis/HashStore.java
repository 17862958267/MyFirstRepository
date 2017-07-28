package com.oracle.qlu.jedis;


import java.util.HashMap;

import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class HashStore {
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
			    //jedis.hset("myHash", "username", "jack");
			    jedis.del("myHash","username");
			    String name = jedis.hget("myHash", "username");
			    System.out.println(name);
				 }catch(Exception e){
					 e.printStackTrace();
				 }finally{
					 if(jedis!=null)jedis.close();
					 if(pool!=null)pool.close();
				 }
	}
  @Test
  public void test1(){
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
	    Map<String,String> map = new HashMap<String,String>();
	    map.put("name", "jack");
	    map.put("age", "21");
	    jedis.hmset("dog", map);
	    //取值
	   System.out.println(jedis.hvals("dog"));
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 if(jedis!=null)jedis.close();
			 if(pool!=null)pool.close();
		 }
	  
  }
}
