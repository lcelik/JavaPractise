package com.sujata.persistence;


import java.util.Collection;

import com.sujata.entity.Book;

public interface BookDao {

	Collection<Book> getAllRecords();
    Book searchRecord(int id);
    int insertRecord(Book book);
    int updateNoOfCopies(int id, int increment);
}
