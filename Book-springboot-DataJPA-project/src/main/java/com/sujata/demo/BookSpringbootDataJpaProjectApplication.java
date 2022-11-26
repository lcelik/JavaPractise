package com.sujata.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.presentation.BookPresentation;

@SpringBootApplication(scanBasePackages = "com.sujata")
@EntityScan(basePackages = "com.sujata.entity")
@EnableJpaRepositories(basePackages = "com.sujata.persistence")
public class BookSpringbootDataJpaProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer= SpringApplication.run(BookSpringbootDataJpaProjectApplication.class, args);
		
        Scanner scanner=new Scanner(System.in);
		
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("Presentation");
		
		 while(true) {
	            
	            bookPresentation.showMenu();
	            System.out.println("Enter Your Selection : ");
	            
	            int userChoice = scanner.nextInt();
	            bookPresentation.performMenu(userChoice);
	        }
	}

}
