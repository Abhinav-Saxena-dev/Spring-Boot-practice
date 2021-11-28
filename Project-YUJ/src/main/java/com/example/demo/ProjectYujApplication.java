package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.controllers.UserController;

@SpringBootApplication
public class ProjectYujApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectYujApplication.class, args);
	}

}
