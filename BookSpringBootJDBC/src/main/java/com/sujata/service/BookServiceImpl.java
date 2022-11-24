package com.sujata.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.entity.Book;
import com.sujata.persistence.BookDao;

@Service("service")
public class BookServiceImpl implements BookService {
	
	@Autowired
    private BookDao bookDao;
    
    // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
//    public BookServiceImpl(@Autowired BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

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

	@Override
	public boolean incrementNoOfCopies(int id, int increment) {
		
if(bookDao.updateNoOfCopies(id, increment) > 0) {
            return true;
            } else {
            return false;
        }
	}

}
