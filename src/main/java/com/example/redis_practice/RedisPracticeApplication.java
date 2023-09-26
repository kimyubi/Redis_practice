package com.example.redis_practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import com.example.redis_practice.service.ChatService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableRedisHttpSession
@EnableCaching
@RequiredArgsConstructor
public class RedisPracticeApplication implements CommandLineRunner {

	private final ChatService chatService;

	public static void main(String[] args) {
		SpringApplication.run(RedisPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started..");
		chatService.enterChatRoom("Chat1");

	}
}
