package com.jsp.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogInApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogInApplication.class, args);
		System.out.println("Ran Succesfully");
	}

}
