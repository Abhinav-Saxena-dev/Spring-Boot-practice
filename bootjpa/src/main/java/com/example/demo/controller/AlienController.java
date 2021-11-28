package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController  // this means that all the controllers(methods) will return data as return type. Don't have to
                 // to use @ResponseBody again and again.
public class AlienController {
	
	@Autowired
	AlienRepo repo;  // simply creating an object of our repository and letting spring boot auto wire and inject the object.
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(int aid) {
//		
//		ModelAndView mv = new ModelAndView("showAlien.jsp"); // alternative to setViewName of Model and view
//		Alien alien;
//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("Java"));
//		alien = repo.findById(aid).orElse(new Alien()); // Option Alien??? .orElse(-----)
//		mv.addObject(alien); 
//		return mv;
//	}
	
	// Added jackson data format for xml.
	
//	@RequestMapping("/aliens")  // @RequestMapping(path="/aliens", produces={"application/xml"}
//	                            // the above format defines the state of output that will be given out.
//	                            // if user tries to ask json from aliens now, then 406 error is outputted
	
	
	@PostMapping(path="/alien")  // specifically defines that this method will only accept post requests.
	// consumes sets what type of request a method accepts.
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
	
	@GetMapping("/aliens")
//	@ResponseBody           // since we are sending data and not a file as response, we have to use response body
	public List<Alien> getAliens() {
		
		return repo.findAll(); // repo.findall returns an iterable by default so we have changed it to a string. ITERABLE??
	}
	
	@GetMapping("/alien/{aid}") // this is a way of taking data from client from url in RequestMapping.
//	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
	}
	
	@DeleteMapping("/alien/{aid}")  // this mapping allows us to accept a delete request from the client.
	public String deleteAlien(@PathVariable("aid") int aid) {
		
		Alien a = repo.getOne(aid);  // returns the entity corresponding the defined identifier(aid here)
		
		repo.delete(a);
		
		return "deleted";
	}
	
	@PutMapping("/alien/{aid}")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

}
