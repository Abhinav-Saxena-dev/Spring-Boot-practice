package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index.html";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		repo.save(user);
		return "register_successful";
	}
}
