package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;

@SpringBootApplication
public class SpringSecurityLearnDemoApplication implements CommandLineRunner {

	@Autowired 
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearnDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("john", bCrypt.encode("hello"), "john@mail.com", "ROLE_NORMAL");
		userRepo.save(user1);

		User user2 = new User("don", bCrypt.encode("pello"), "don@mail.com", "ROLE_ADMIN");
		userRepo.save(user2);
	}
}
