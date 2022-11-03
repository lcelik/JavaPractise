package com.sujata.classes;

public class Circle implements Drawable, Fillable {
	
	public Circle() {
		super();
	}

	@Override
	public void drawingColor() {
		System.out.println("Drawing the color");
		
	}

	@Override
	public void thickness() {
		System.out.println("Thickness");
		
	}

	@Override
	public void fillingColor() {
		System.out.println("Filling the color");
		
	}

	@Override
	public void size() {
		System.out.println("This is the circle's size...");
		
	}

}
