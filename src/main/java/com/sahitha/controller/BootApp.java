package com.sahitha.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
/* @EnableJpaRepositories(basePackages = "com") */
public class BootApp {
	public static void main(String[] args) {
		SpringApplication.run(BootApp.class, args);
	}

}
