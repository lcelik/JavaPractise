package com.sujata.arrays;

import java.util.Scanner;

public class PersonListClassMain {

	public static void main(String[] args) {
		
		
	    Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the number of persons: ");
		int totalNumber = myScanner.nextInt();
		
		
		
		PersonList personList;
	    personList = new PersonList(totalNumber);
	
	for (int index = 0; index < totalNumber; index++) {
		Person person = new Person();
		
		System.out.println("Enter " + (index + 1) + " person Id: ");
		person.setPersonId(myScanner.nextInt());
		
		System.out.println("Enter " + (index + 1) + " person Name: ");
		person.setName(myScanner.next());
		
		System.out.println("Enter " + (index + 1) + " person Age: ");
		person.setAge(myScanner.nextInt());
		
		personList.inputPerson(person, index);
	}
	
	personList.displayPersonList();
	
	}
}
