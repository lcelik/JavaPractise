package com.sujata.exceptions;


public class Employee {
	
	private String name;
	private int age;
	
	public Employee() {
		
	}
	
	

	public Employee(String name, int age) throws AgedCheckedException {
		if(age <= 18 && age <= 60) { //first condition
			this.name = name;
			this.age = age;
		} else {
			throw new AgedCheckedException("Age must be between 18 and 60");
		}
	}



	public String getName() {
		return name;
	}

	public void setName(String name) throws NameCheckedException {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgedCheckedException {
        if(age >= 18 && age <= 60) {  //first condition
			this.age = age;
		} else {
			throw new AgedCheckedException("Age must be between 18 and 60");
		}
		}
	
	//method for displaying the Employee
	public void display() {
		System.out.println("Employee Name: " + name);
		System.out.println("Employee Age: " + age);
		
	}

	

//	Create a class called Employee which asks the user to input the name and the age of a 
//	employee. Raise a custom defined exception when the user enters an employee name 
//	that has been already entered and raise another exception if the age is negative or less
//	than 18 or greater than 60.

}
