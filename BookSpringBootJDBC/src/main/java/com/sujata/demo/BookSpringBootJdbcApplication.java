package com.sujata.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sujata.presentation.BookPresentation;

@SpringBootApplication(scanBasePackages = "com.sujata")
public class BookSpringBootJdbcApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer = SpringApplication.run(BookSpringBootJdbcApplication.class, args);
		
		Scanner scanner=new Scanner(System.in);
		
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bkPresentation");
		
		 while(true) {
	            
	            bookPresentation.showMenu();
	            System.out.println("Enter Your Selection : ");
	            
	            int userChoice = scanner.nextInt();
	            bookPresentation.performMenu(userChoice);
	        }
	}

}
