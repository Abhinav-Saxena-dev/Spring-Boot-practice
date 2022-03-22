package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.UserService;
import com.example.demo.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();	
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
		}
	
	@PostMapping("/")
	public User add(@RequestBody User user) {
		return userService.addUser(user);
	}
}
