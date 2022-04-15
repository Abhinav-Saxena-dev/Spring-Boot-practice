package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable String username) {
		return userRepo.findByUsername(username);
	} 
		
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
}
