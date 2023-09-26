package com.example.redis_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis_practice.dto.UserProfile;
import com.example.redis_practice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {

	private final UserService userService;

	@GetMapping("/users/{userId}/profile")
	public UserProfile getUserProfile(@PathVariable String userId) throws InterruptedException {
		return userService.getUserProfile(userId);
	}
}
