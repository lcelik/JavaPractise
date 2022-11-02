package com.sujata.arrays;

public class Person {
	
private String name;
private int age;
private int personId;

//default constructor
public Person() {
	
}

//constructor with parameters
public Person(String name, int age, int personId) {
	super();
	this.name = name;
	this.age = age;
	this.personId = personId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}


//method for displaying the Person
public void display() {
	System.out.println("Person Id: " + personId);
	System.out.println("Name: " + name);
	System.out.println("Age: " + age);
}

}
