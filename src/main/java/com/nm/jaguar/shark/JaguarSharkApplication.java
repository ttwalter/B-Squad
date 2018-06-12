package com.nm.jaguar.shark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JaguarSharkApplication {
	
	public static void main(String... args) {
		
		ApplicationContext context = SpringApplication.run(JaguarSharkApplication.class, args);
		
	}
}
