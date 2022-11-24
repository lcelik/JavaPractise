/**
 *
 * @author lidija
 * <------- STEP 4 : CREATE DATA ACCESS OBJECT ----->
 * 
 */

package com.teamsix.book.persistence;

import java.util.Collection;

import com.teamsix.book.entity.Book;


public interface BookDao {
	
	Collection<Book> getAllRecords();
	Book searchRecord(int id);
	int insertRecord(Book book);
}



