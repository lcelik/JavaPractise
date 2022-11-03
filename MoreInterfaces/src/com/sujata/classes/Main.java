package com.sujata.classes;

public class Main {
	public static void main(String[] args) {
		
		Circle circle=new Circle(6);
		circle.area();
		circle.circumference();
		circle.display();

		Rectangle rectangle=new Rectangle(4, 7);
		rectangle.area();
		rectangle.perimeter();
		rectangle.display();
		
	}
}
