package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	 @Query("SELECT u FROM User u where u.email = ?1")
     User findByEmail(String email);
}
