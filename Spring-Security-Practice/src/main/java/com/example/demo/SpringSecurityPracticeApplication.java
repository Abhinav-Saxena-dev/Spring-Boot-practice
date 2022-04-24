package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;

@SpringBootApplication
@Profile("!test")
public class SpringSecurityPracticeApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPracticeApplication.class, args);
	}
}
