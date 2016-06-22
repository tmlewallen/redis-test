package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisConfig {
	
	@Bean
	public JedisPool getRedisConnection(){
		return new JedisPool(new JedisPoolConfig(), "localhost");
	}
}
