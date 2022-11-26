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
    

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public Book searchBookById(int id) {
		
		return bookDao.findById(id).orElse(null);
	}

	@Override
	public boolean addBook(Book book) {

		if (searchBookById(book.getBookId()) == null) {
			
			// save means : save and update
			bookDao.save(book);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementNoOfCopies(int id, int increment) {
		
     Book book = searchBookById(id);
     
     if(book != null) {
    	 book.setNoOfCopies(book.getNoOfCopies() + increment);
    	 bookDao.save(book);
    	 return true;
     }
     return false;
	}

	@Override
	public boolean deleteBook(int id) {
		
		if(searchBookById(id) != null) {
			bookDao.deleteById(id);
			return true;
		}
		
		return false;
	}
}
