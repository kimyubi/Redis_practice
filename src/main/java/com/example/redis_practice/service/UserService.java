package com.example.redis_practice.service;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.redis_practice.dto.UserProfile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final ExternalApiService externalApiService;
	private final StringRedisTemplate redisTemplate;

	public UserProfile getUserProfile(String userId) throws InterruptedException {
		String name;
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		String cachedName = ops.get("nameKey : " + userId);

		if(cachedName != null){
			name = cachedName;
		}
		else{
			name = externalApiService.getUserName(userId);
			ops.set("nameKey : " + userId, name, 5, TimeUnit.SECONDS);
		}
		int age = externalApiService.getUserAge(userId);

		return new UserProfile(name, age);
	}
}
