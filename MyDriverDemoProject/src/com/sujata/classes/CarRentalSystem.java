package com.sujata.classes;

public class CarRentalSystem {
	public static void main(String[] args) {
		
		Honda honda = new Honda("City", "Blue");
		
		Driver john = new Driver("John");
		
		john.setCar(honda);
		john.drive();
	}
}
