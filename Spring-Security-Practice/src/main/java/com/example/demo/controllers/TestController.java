package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login.html";
	}
	
}
