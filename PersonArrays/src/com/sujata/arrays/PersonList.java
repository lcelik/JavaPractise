package com.sujata.arrays;

import java.util.Scanner;

public class PersonList {

	private Person[] persons; //array of persons
	private int totalNoOfPersons;
	
	
	public PersonList(int totalNoOfPersons) {
		super();
		this.totalNoOfPersons = totalNoOfPersons;
		persons = new Person[totalNoOfPersons];
	}
	
	//methods to manipulate array(input person and display person from array
	
	public void inputPerson(Person person, int index) {
		persons[index] = person;
	}
	
	public void displayPersonList() {
		for(int index = 0; index < totalNoOfPersons; index++) {
			persons[index].display();
		}
	}
	
}
