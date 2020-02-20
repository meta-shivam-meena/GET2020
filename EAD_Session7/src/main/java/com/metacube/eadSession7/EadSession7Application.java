package com.metacube.eadSession7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.metacube.eadSession7.controller", "com.metacube.eadSession7.mailSender", "com.metacube.eadSession7.config"})
public class EadSession7Application {

	public static void main(String[] args) {
		SpringApplication.run(EadSession7Application.class, args);
	}

}
