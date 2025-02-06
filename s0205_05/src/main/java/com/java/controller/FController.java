package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("get 방식으로 들어왔습니다.");
		return "login";
	}
	
	@PostMapping("/login")
	public String dologin(HttpServletRequest request) {
		session.setAttribute("session_id", "aaa");
		System.out.println("post 방식으로 들어왔습니다.");
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "logout";
	}
}
