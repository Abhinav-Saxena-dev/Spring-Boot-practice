package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
@Component("lap1") // now qualifier searches for this class by the name of lap1;
public class Laptop {
	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void compile() {
		System.out.println("Compiling....");
	}
}
