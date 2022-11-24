/**
 *
 * @author lidija
 * <------ 1st STEP : CREATE POJO - encapsulated entity - getters & setters / lombok API -------->
 */

package com.sujata.entity;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
public class Book {

	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfCopies;
	
	public Book() {
		
	}

	public Book(int bookId, String bookName, String authorName, int noOfCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.noOfCopies = noOfCopies;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", noOfCopies="
				+ noOfCopies + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookId, bookName, noOfCopies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName) && noOfCopies == other.noOfCopies;
	}
	
	
}
