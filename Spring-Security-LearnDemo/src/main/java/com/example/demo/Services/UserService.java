	package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;

@Service
public class UserService {

	List<User> list = new ArrayList<User>();

	public UserService() {
		list.add(new User("abc", "abc", "abc@xyz.com", "NORMAL"));
		list.add(new User("rst", "rst", "rst@xyz.com", "NORMAL"));	;
	}

	public List<User> getAllUsers() {
		return this.list;
	}

	public User getUser(String username) {
		return this.list.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	public User addUser(User user) {
		this.list.add(user);
		return user;
	}

}
