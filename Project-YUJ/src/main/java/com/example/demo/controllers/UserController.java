package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	private UserRepo repo;
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		repo.save(user);
		return "Done";
	}
	
	@GetMapping("/findUser/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return repo.findById(id);
	}
	
	@GetMapping("/findUsers")
	public List<User> getUsers(){
		return repo.findAll();
	}
}

// Observations : All the package name must be similar. Like it's in this project. Or just put all the packages as that of main application file.