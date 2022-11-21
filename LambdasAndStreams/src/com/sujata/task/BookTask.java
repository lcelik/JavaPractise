package com.sujata.task;


import java.util.ArrayList;
import java.util.List;

public class BookTask {
	public static void main(String[] args) {
		
		List<Book> bookList = new ArrayList();

		bookList.add(new Book(1, "Book 1", "Author A", 1200, 5000));
		bookList.add(new Book(2, "Book 2", "Author M", 2100, 2000));
		bookList.add(new Book(3, "Book 3", "Author A", 3000, 6000));
		bookList.add(new Book(4, "Book 4", "Author D", 800, 2800));
		bookList.add(new Book(5, "Book 5", "Author M", 7200, 1100));
		bookList.add(new Book(6, "Book 6", "Author A", 8200, 4300));
		bookList.add(new Book(7, "Book 7", "Author A", 7900, 5600));
		
		
//with filter 
		bookList.stream()
		.filter(book->book.getPrice()>5000)
		.map(book->new BookDiscount(book, book.getPrice()*.10))
		.forEach(bookWithDiscount->System.out.println(bookWithDiscount));
		
	//	"Write a stream operation to read list of books and give 10% discount to the books
//with price greater than 5000 and 5% discount to the books with price less than or equal to 5000."
			
		
		bookList.stream()
		
		.map(book -> {
			
			BookDiscount bookWithDiscount = null;
			
			if (book.getPrice() > 5000)
				bookWithDiscount = new BookDiscount(book, book.getPrice() * .10);
			else if (book.getPrice() < 5000)
				bookWithDiscount = new BookDiscount(book, book.getPrice() * .5);
			return bookWithDiscount;
		}
	).forEach(bookWithDiscount -> System.out.println(bookWithDiscount));
		
}
}
