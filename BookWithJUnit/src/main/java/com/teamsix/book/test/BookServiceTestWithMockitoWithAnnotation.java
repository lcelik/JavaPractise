package com.teamsix.book.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;
import com.teamsix.book.persistence.BookDaoImpl;
import com.teamsix.book.service.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTestWithMockitoWithAnnotation {
	
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	
	@Mock
	private BookDao bookDao;
	private AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		
		/*
		 * tells mockito to scan the test class instance 
		 * for all the fields annotated with @Mock
		 * and initialize those fields as mocks
		 * 
		 */
		
		autoCloseable=MockitoAnnotations.openMocks(this);
		
//		bookServiceImpl = new BookServiceImpl();
//		
//		bookDao = Mockito.mock(BookDao.class);
//		bookServiceImpl.setBookDao(bookDao);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
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

//	@Test
//	void testSearchBookById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddBook() {
//		fail("Not yet implemented");
//	}

}
