package com.sujata.practise;

//
//Create a Height class which represents height in feet and inches.
//Create setters, getters and sum method to calculate sum of two height objects.
//Note :
//1 feet = 12 inches
//Make sure you must get height in proper unit after adding two height objects as well.

public class Height {
    
	private int feet;
	private int inches;
	
	
	 public Height() {
         super();
     }
	
	//constructor
	public Height(int feet, int inches) {
		super();
		this.feet = feet;
		this.inches = inches;
	}
	
	public int getFeet() {
		return feet;
	}
	
	
	public void setFeet(int feet) {
		this.feet = feet;
	}
	public int getInches() {
		return inches;
	}
	public void setInches(int inches) {
		this.inches = inches;
	}
	
	//method to calculate sum of two height objects
	public void sumHeight(Height person1, Height person2) {
		this.feet = person1.getFeet() + person2.getFeet();
		this.inches = person1.getInches() + person2.getInches();
		
		if(inches >= 12) {
			feet = feet + inches / 12;
			inches = inches % 12;
		}
	}
	
}
