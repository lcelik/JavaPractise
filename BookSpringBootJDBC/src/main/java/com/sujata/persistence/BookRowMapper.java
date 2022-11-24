package com.sujata.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.sujata.entity.Book;


public class BookRowMapper implements RowMapper<Book> {

	@Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
       
        int id = rs.getInt("BOOKID");
        String name = rs.getString("NAME");
        String authorName = rs.getString("AUTHOR");
        int noOfCopies = rs.getInt("COPIES");
        
        Book book = new Book(id, name, authorName, noOfCopies);
        return book;
    }
	
}
