package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;

@SpringBootApplication
@Profile("!test")
public class SpringSecurityPracticeApplication implements CommandLineRunner{
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Autowired
	UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPracticeApplication.class, args);
	}

	@Override                           // COMMAND LINE RUNNER EXECUTING EVERY TIME APPLICATION IS STARTED>
	public void run(String... args) throws Exception {
		User user1 = new User("dika@gmail.com", "Dika", bcrypt.encode("pass1"), "ROLE_NORMAL");
		User user2 = new User("pika@gmail.com", "Pika", bcrypt.encode("pass2"), "ROLE_ADMIN");
		userRepo.save(user1);
		userRepo.save(user2);
	}
}
