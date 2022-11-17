/**
 *
 * @author lidija
 * <------ STEP 10 : CREATES DAO OBJECT TO TELL GET RETRIEVE/ADD DATA TO DATABASE ------>
 */
package com.teamsix.book.service;

import java.util.Collection;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;


public class BookServiceImpl implements BookService {
	
	   private BookDao bookDao;
	   
	   // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
	    public BookServiceImpl(BookDao bookDao) {
	        this.bookDao = bookDao;
	    }

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllRecords();
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchRecord(id);
	}

	@Override
	public boolean addBook(Book book) {
		
        if (bookDao.insertRecord(book) > 0) {
        	
            return true;
            
        } else {
           
            return false;
	}
    
}
	}
