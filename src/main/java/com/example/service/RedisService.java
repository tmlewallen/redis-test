package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
	
	@Autowired
	JedisPool pool;
	
	@HystrixCommand(fallbackMethod="getFallback")
	public String getVal(String key){
		try (Jedis jedis = pool.getResource()){
			return jedis.get(key);
		}
	}
	
	@HystrixCommand(fallbackMethod="getFallback")
	public String putKeyVal(String key, String val){
		try (Jedis jedis = pool.getResource()){
			jedis.set(key, val);
			return "Success";
		}
	}
	
	protected String getFallback(){
		return "Connection Failure";
	}
}
