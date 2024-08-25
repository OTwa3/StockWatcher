package com.mystockcheck.mystockcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EntityScan(basePackages = "com.mystockcheck.mystockcheck.models")
//@EnableJpaRepositories(basePackages = "com.mystockcheck.mystockcheck.models")
public class MystockcheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(MystockcheckApplication.class, args);
		
	}

}
