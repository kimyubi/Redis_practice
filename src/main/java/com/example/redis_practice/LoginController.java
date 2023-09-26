package com.example.redis_practice;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String login(HttpSession session, @RequestParam String name){
		session.setAttribute(session.getId(), name);
		return "saved.";
	}


	@GetMapping("/my-name")
	public String myName(HttpSession session){
		String myName = (String)session.getAttribute(session.getId());
		return myName;
	}
}
