package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.services.UserServiceImpl;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	public UserRegistrationController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping("")
	public String showRegistration() {
		return "register.html";
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistration() {
		return new UserRegistrationDto();
	}
	
	@PostMapping("")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userServiceImpl.save(registrationDto);
		return "redirect:/registration?success";
	}
	
	@PostMapping("/newuser")
	public String registerJson(@RequestBody UserRegistrationDto registrationDto) {
		userServiceImpl.save(registrationDto);
		return "redirect:/registration?success";
	}
}
