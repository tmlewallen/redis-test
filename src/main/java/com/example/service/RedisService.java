package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
	
	@Autowired
	JedisPool jedisPool;
	
	public String getVal(String key){
		try (Jedis jedis = jedisPool.getResource()){
			return jedis.get(key);
		}
	}
	
	public boolean putKeyVal(String key, String val){
		try (Jedis jedis = jedisPool.getResource()){
			jedis.set(key, val);
			return true;
		}
	}
}
