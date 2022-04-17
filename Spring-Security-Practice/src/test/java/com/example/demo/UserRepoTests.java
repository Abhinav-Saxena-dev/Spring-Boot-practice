package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)   // ERROR WAS BEING SHOWN WITHOUT THIS LINE. WHYYYY
public class UserRepoTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entitymanager;
	
	@Test
	public void testCreateUser() {
		User user = new User("princeofpersia@gmail.com", "dastan", "sandsoftime", "ROLE_ADMIN");
		
		User savedUser = repo.save(user);
		
		User existUser = entitymanager.find(User.class, savedUser.getId());   // WHYYYYY
		
		assertThat(existUser.getUsername()).isEqualTo(savedUser.getUsername());
	}
	
	@Test
	public void deleteUser() {
		User user = new User("princeofpersia@gmail.com", "dastan", "sandsoftime", "ROLE_NORMAL");
		
		User savedUser = repo.save(user);
		
		repo.delete(savedUser);
		
		User existUser = entitymanager.find(User.class, savedUser.getId());   // WHYYYYY
		
		assertThat(existUser).isNull();
	}	
}
