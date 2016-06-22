package com.example.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.KeyValPair;
import com.example.service.RedisService;

@RestController()
@RequestMapping(path="/redis")
public class RedisRestController {

	@Autowired
	RedisService service;
	
	@RequestMapping(path="/get", method=RequestMethod.GET)
	public String getVal(@QueryParam("key") String key){
		return service.getVal(key);
	}
	
	@RequestMapping(path="/put", method=RequestMethod.POST)
	public boolean putKeyVal(@RequestBody KeyValPair pair){
		return service.putKeyVal(pair.getKey(), pair.getVal());
	}
}
