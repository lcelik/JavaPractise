package com.teamsix.book.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDaoImpl;

class BookDaoTest {
	
	BookDaoImpl bookDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl = null;
	}

	@Test
	void testGetAllRecords() {
		assertTrue(bookDaoImpl.getAllRecords().size()>0);
	}

	@Test
	void testSearchRecord() {
		assertTrue(bookDaoImpl.searchRecord(128)!=null);
	}

	@Test
	void testInsertRecord() {
		assertEquals(1, bookDaoImpl.insertRecord(new Book(133, "Hello", "Lidija Celik", 666)));
	}

}
