package com.example.redis_practice.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

	public String getUserName(String userId) throws InterruptedException {
		// 외부 서비스나 DB 호출

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

	public int getUserAge(String userId) throws InterruptedException {
		// 외부 서비스나 DB 호출

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
