package com.sujata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Book {

	@Id
	@Column(name = "bookId")
	private int bookId;
	
	@Column(name = "name")
	private String bookName;
	
	@Column(name = "author")
	private String authorName;
	
	@Column(name = "copies")
	private int noOfCopies;
}
