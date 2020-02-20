package com.metacube.eadSession8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.metacube.eadSession8.controller", "com.metacube.eadSession8.service",
		"com.metacube.eadSession8.dao", "com.metacube.eadSession8.model", "com.metacube.eadSession8.config"})
public class EadSession8Application {

	public static void main(String[] args) {
		SpringApplication.run(EadSession8Application.class, args);
	}

}
