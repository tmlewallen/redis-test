package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisConfig{
			
	@Bean
	@HystrixCommand(fallbackMethod = "getFallback")
	public JedisPool getJedisPool() throws Exception {
		return new JedisPool(new JedisPoolConfig(), "localhost");
	}
	
	protected JedisPool getFallback(){
		return null;
	}
}
