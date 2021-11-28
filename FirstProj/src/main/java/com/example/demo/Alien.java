package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	// Using @component creates an instance/bean of the class inside the spring container.
	
		private int id;
		private String name, tech;
		@Autowired
		@Qualifier("lap1")              
		private Laptop laptop;
		// Autowired searches for the object in the spring container by TYPE, not by the name, and connects the two classes.
		
		// Qualifire("name") searches the spring container by the name;
		// Qualifier cannot be used without autowired.
		
		
		
		public Alien() {
			System.out.println("Object created");
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTech() {
			return tech;
		}
		public void setTech(String tech) {
			this.tech = tech;
		}
		public void display() {
			System.out.println("HEyyyyy");
			laptop.compile();
		}
}
