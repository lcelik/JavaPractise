package com.sujata.classes;

public class MirrorTheNumber {
 private int number, mirror;

public void setNumber(int number) {
	this.number = number;
}


public int getMirror() {
	calculateMirroredNumber();
	return mirror;
}

private void calculateMirroredNumber(){

  while(number >=0) {
mirror = mirror * 10;
mirror = mirror + (number % 10);
      number = number / 10;
} 
}
 
}
