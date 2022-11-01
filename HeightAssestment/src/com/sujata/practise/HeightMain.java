package com.sujata.practise;

public class HeightMain {

	public static void main(String[] args) {
		
		Height person1 = new Height(5, 8);
		Height person2 = new Height(6, 7);
		Height height = new Height();
		
		height.sumHeight(person1, person2);
		System.out.println("Sum : " + height.getFeet() + " feets " + height.getInches() + " inches");

	}

}
