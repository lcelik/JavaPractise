package com.sujata.service;

import java.util.Collection;

import com.sujata.entity.Book;

public interface BookService {


    // COLLECTION FOR ALL BOOKS
    Collection<Book> getAllBooks();
    
    // BOOK OBJECT TO SEARCH BY ID
    Book searchBookById(int id);
    
    // BOOLEAN TO CHECK IF BOOK EXISTS BEFORE ADDING NEW BOOK OBJECT
    boolean addBook(Book book);
    
    boolean incrementNoOfCopies(int id, int increment);
    
    boolean deleteBook(int id);
}
