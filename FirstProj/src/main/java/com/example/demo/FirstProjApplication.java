package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) { 
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjApplication.class, args);
		// the run method of SpringApplication returns object of type configurableApplicationContext
		// The run method here, when it runs, the spring container is created, initializing the container.
		
        // Alien ob = new Alien(); This is us creating the java object manually, but spring boot says that hey dev, you 
		// focus on the code, we'll handle the object.
		
		Alien ob = context.getBean(Alien.class);
		// this gives error if we don't specify to context which classes need to have an object initialized, using annotation
		// @Component.
		
		// The moment run() method is run after creating @component, we are provided with an object of that class beforehand.
		
		// This is basically spring framework injecting an object into our application and this is known as dependency 
		// injection.
		
		ob.display();
		
		/*
		 * 
		 * Alien ob2 = context.getBean(Alien.class);
		 * 
		 * ob2.display(); 
		 * System.out.println(ob + "  " + ob2); 
		 * 
		 * // it can be noted that
		 * display of the class Alien is called two times but ob and ob2 point to the
		 * same address. // As said already, spring framework provides us with the
		 * object beforehand(Singleton) and we can't create multiple // by called
		 * getBeans() again and again.
		 * 
		 * But if we are using prototype, we get the object only when we use
		 * getBeans() thus stopping the singleton // object creation.
		 *
		 */
		
		
		
		}

}
 