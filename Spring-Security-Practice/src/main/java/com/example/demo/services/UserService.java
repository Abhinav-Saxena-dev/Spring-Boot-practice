package com.example.demo.services;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.models.User;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
}
