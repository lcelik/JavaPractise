package com.sujata.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sujata.entity.Book;
import com.sujata.service.BookService;

@Component("Presentation")
public class BookPresentationImpl implements BookPresentation {
	

	 //Presentation will pass the request to service for processing and gives response to client
	@Autowired
   private BookService bookService;
   
   

	@Override
	public void showMenu() {
		
		  System.out.println("===========================");
         System.out.println("Book Management System");
         System.out.println("1. List All Books");
         System.out.println("2. Search Book By ID");
         System.out.println("3. Add New Book");
         System.out.println("4. Update Number of Copies");
         System.out.println("5. Delete Book");
         System.out.println("6. Exit");
         System.out.println("============================");
	}

	@Override
	public void performMenu(int choice) {
		
		Scanner scanner=new Scanner(System.in);
       
		switch (choice) {
                   
		case 1:
			Collection<Book> books=bookService.getAllBooks();
			for(Book book:books) {
				System.out.println(book);
			}
			break;
                       
		case 2:
			System.out.println("Enter Book ID : ");
			int id=scanner.nextInt();
			Book book=bookService.searchBookById(id);
			if(book!=null)
				System.out.println(book);
			else
				System.out.println("Book with id "+id+" does not exist");
			break;
                 
			
        case 3:
       	 
			Book newBook = new Book();
			
			System.out.println("Enter Book id : ");
			newBook.setBookId(scanner.nextInt());
			System.out.println("Enter Book Name : ");
			newBook.setBookName(scanner.next());
                       System.out.println("Enter Author Name : ");
			newBook.setAuthorName(scanner.next());
                       System.out.println("Enter Number of Copies : ");
			newBook.setNoOfCopies(scanner.nextInt());
			
			if(bookService.addBook(newBook))
				System.out.println("Book Record Added");
			else
				System.out.println("Book with id "+newBook.getBookId()+" already exist, so cannot add it as a new book!");
			
			break;	
                       
               case 4:
                       System.out.println("Enter Book ID : ");
                       int bkId = scanner.nextInt();
                       
                       System.out.println("Enter Increment Amount : ");
                       int increment = scanner.nextInt();
                       
                       if(bookService.incrementNoOfCopies(bkId, increment)) {
                           System.out.println("Book with ID : " + bkId + " copies incremented by " + increment);
                       } else {
                           System.out.println("Book with ID" + bkId + " does not exist");
                       }
                       break;
                       
               case 5:
                   System.out.println("Enter Book ID : ");
                   int bookId = scanner.nextInt();
 
                   if(bookService.deleteBook(bookId)) {
                       System.out.println("Book with ID : " + bookId + " is deleted ");
                       
                   } else {
                	   
                       System.out.println("Book with ID" + bookId + " does not exist");
                   }
                   break;
                       
		case 6:
			System.out.println("Thanks for using Book Management System");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice!");
			break;
			
		}
		
	}

}
