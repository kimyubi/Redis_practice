package com.example.redis_practice.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

	public String getUserName(String userId) throws InterruptedException {
		// 외부 서비스나 DB 호출
		System.out.println("getUserName......");


		Thread.sleep(1000);

		if (userId.equals("a")){
			return "Adam";
		}
		else if(userId.equals("b")){
			return "bab";
		}
		else
			return "";
	}

	@Cacheable(cacheNames = "userAgeCache", key = "#userId", cacheManager = "cacheManager")
	public int getUserAge(String userId) throws InterruptedException {
		// 외부 서비스나 DB 호출
		System.out.println("getUserAge......");
		Thread.sleep(1000);

		if (userId.equals("a")){
			return 13;
		}
		else if(userId.equals("b")){
			return 23;
		}
		else
			return 0;
	}
}
