package com.example.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.ems.repository")
public class EmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}
}

