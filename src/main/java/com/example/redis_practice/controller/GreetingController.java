package com.example.redis_practice.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final StringRedisTemplate redisTemplate;

	@GetMapping("/greeting")
	public String greeting(){
		return "Hello World!";
	}

	@GetMapping("/set-fruit")
	public String setFruit(@RequestParam String name){
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set("fruit", name);

		return "과일 {" + name + "} 이(가) 저장되었습니다.";
	}

	@GetMapping("/get-fruit")
	public String setFruit(){
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		String fruit = ops.get("fruit");

		return "과일 {" + fruit + "}";
	}
}
