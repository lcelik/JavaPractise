/**
 *
 * @author lidija
 * <------ STEP 10 : CREATES DAO OBJECT TO TELL GET RETRIEVE/ADD DATA TO DATABASE ------>
 */
package com.teamsix.book.service;

import java.util.Collection;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;
import com.teamsix.book.persistence.BookDaoImpl;

import lombok.Setter;


public class BookServiceImpl implements BookService {
	
	//Service will request persistence layer for all data needs
	
		@Setter
	   private BookDao bookDao;
		
//	private BookDao bookDao = new BookDaoImpl();
	   
	   // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
//	    public BookServiceImpl(BookDao bookDao) {
//	        this.bookDao = bookDao;
//	    }
//	    
//	    public BookServiceImpl() {
//			
//		}

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
		
//		int rows = bookDao.insertRecord(book);
//		
//		if(rows == 0) {
//			return false;
//		}
//		else
//			return true; 
		
		if(bookDao.insertRecord(book)>0)
			return true;
		return false;
	}
    
        
//        public boolean updateBook(Book book) {
//    		//Book myBook = bookDao.searchRecords(book.getId());  //commented out this stuff as its before adding the JDBC 
//    		
//    		int rows = bookDao.updateRecord(book);
//    		if(rows == 0) {
//    			//bookDao.insertRecord(book);
//    			return false;
//    		} else
//    			return true;
//        }
}
	
