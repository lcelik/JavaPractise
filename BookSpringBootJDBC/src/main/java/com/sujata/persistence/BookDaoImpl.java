package com.sujata.persistence;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 

	@Override
	public Collection<Book> getAllRecords() {
		
		  String query = "SELECT * FROM BOOK";
	        List<Book> bookList = jdbcTemplate.query(query, new BookRowMapper());
	   
	        return bookList;
	}

	@Override
	public Book searchRecord(int id) {
		
		 Book book = null;
	        
	        try {

	                String query = "SELECT * FROM BOOK WHERE BOOKID=?";
	                book = jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
	        } catch (EmptyResultDataAccessException ex) {
	                return null;
	        }
	        return book;
	}

	@Override
	public int insertRecord(Book book) {
		
		 try {
	            
	            String query = "INSERT INTO BOOK VALUES(?,?,?,?)";
	            
	            int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNoOfCopies());
	            
	            return rows;
	        
	        } catch (DuplicateKeyException ex) {
	            return 0;
	        }
	}

	@Override
	public int updateNoOfCopies(int id, int increment) {
		
//   String query = "UPDATE BOOK SET NOOFCOPIES = NOOFCOPIES+? WHERE BOOKID=?";
   
   String query = "UPDATE BOOK SET COPIES = COPIES+? WHERE BOOKID=?";
		
	        int rows = jdbcTemplate.update(query, increment, id);
	        
	        return rows;
	    }
	    
	}


