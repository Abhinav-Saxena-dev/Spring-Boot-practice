package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and()
			.authorizeRequests()
			.antMatchers("/signin").permitAll()
			.antMatchers("/public/**").hasRole("NORMAL")
			.antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/users/")
		;
			//.httpBasic();     // WE GET THE LOGIN FORM IN THE POPUP. IN THE BASIC AUTHORIZATION WE HAVE TO PASS THE PASSWORD AND USERNAME WITH EVERY REQUEST, DUE TO THIS THERE IS NO LOGGIN
	}						  // OUT IN THIS TYPE OF AUTHENTICATION.

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("john").password(passwordEncoder().encode("hello")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("don").password(passwordEncoder().encode("pello")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
