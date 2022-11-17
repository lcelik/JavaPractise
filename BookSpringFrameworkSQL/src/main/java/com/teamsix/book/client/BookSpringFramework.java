/**
 *
 * @author lidija
 * 
 */

package com.teamsix.book.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.teamsix.book.presentation.BookPresentation;
import com.teamsix.book.presentation.BookPresentationImpl;


public class BookSpringFramework  {

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(BookConfiguration.class);
        
        BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bkPresentation");
        
//        BookPresentation bookPresentation = new BookPresentationImpl();
        
        while(true) {
            
            bookPresentation.showMenu();
            System.out.println("Enter Your Selection : ");
            
            int userChoice = sc.nextInt();
            bookPresentation.performMenu(userChoice);
        }
    }
}
