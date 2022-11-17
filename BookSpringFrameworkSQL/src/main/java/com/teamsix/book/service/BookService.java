/**
 *
 * @author lidija
 * <------ STEP 5 : MAKES CALLS TO DAO TO RETRIEVE & ADD DATA TO DATABASE ------>
 */

package com.teamsix.book.service;

import java.util.Collection;

import com.teamsix.book.entity.Book;

public interface BookService {
    
	 // COLLECTION FOR ALL BOOKS
    Collection<Book> getAllBooks();
    
    // BOOK OBJECT TO SEARCH BY ID
    Book searchBookById(int id);
    
    // BOOLEAN TO CHECK IF BOOK EXISTS BEFORE ADDING NEW BOOK OBJECT
    boolean addBook(Book book);
}
