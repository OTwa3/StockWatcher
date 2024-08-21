package com.mystockcheck.mystockcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mystockcheck.models") // Add this if your entity is in a different package
public class MystockcheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(MystockcheckApplication.class, args);
	}

}
