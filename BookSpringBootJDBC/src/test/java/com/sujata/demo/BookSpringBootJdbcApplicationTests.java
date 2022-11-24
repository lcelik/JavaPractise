package com.sujata.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.sujata.entity.Book;
import com.sujata.persistence.BookDao;

@SpringBootTest
class BookSpringBootJdbcApplicationTests {
	
	// do not need beforeEach & AfterEach object because using Autowired
    @Autowired
    BookDao dao;

    @DisplayName("List All Books")
	@Test
	public void testGetAllBook() {
    	assertTrue(dao.getAllRecords().size()>0);
	}
    
    @DisplayName("Search Book by ID")
   	@Test
   	public void testSearchRecord() {
    	Book book = new Book(123, "A Fault in Our Stars", "J. Wilson", 10);
    	assertEquals(book, dao.searchRecord(123));
    	
    }
    
//  @DisplayName("Insert Book")
//  @Test
// public void testInsertRecord() {
//     assertEquals(1, dao.insertRecord(new Book(135, "The Army Kid", "Moses", 500)));
// }
   

}
