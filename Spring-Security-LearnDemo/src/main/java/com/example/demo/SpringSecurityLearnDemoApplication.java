package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserRepository;

@SpringBootApplication
public class SpringSecurityLearnDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearnDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
