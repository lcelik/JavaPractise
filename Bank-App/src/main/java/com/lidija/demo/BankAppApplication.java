package com.lidija.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.lidija")
@EntityScan(basePackages = "com.lidija.entity")
@EnableJpaRepositories(basePackages = "com.lidija.model.persistence")
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
