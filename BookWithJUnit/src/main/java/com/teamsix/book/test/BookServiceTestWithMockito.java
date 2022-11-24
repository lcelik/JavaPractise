package com.teamsix.book.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;
import com.teamsix.book.persistence.BookDaoImpl;
import com.teamsix.book.service.BookServiceImpl;


class BookServiceTestWithMockito {
	
	private BookServiceImpl bookServiceImpl;
	private BookDao bookDao;

	@BeforeEach
	void setUp() throws Exception {
		bookServiceImpl = new BookServiceImpl();
		
		bookDao = Mockito.mock(BookDao.class);
		bookServiceImpl.setBookDao(bookDao);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}



	
	@Test
	void testAddBookOne() {
		//Specifying the behavior of the mock
		when(bookDao.insertRecord(new Book(128, "BookTitle", "Lidija", 250).thenReturn(1)));
		
		assertTrue(bookServiceImpl.addBook(new Book(128, "BookTitle", "Lidija", 250)));
	}
	
	@Test
	void testAddBookTwo() {
		//Specifying the behavior of the mock
		
		when(bookDao.insertRecord(new Book(128, "BookTitle", "Lidija", 250).thenReturn(0)));
		
		assertFalse(bookServiceImpl.addBook(new Book(128, "BookTitle", "Lidija", 250)));
	}




}
