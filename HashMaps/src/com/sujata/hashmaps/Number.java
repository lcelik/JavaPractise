package com.sujata.hashmaps;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Number {
	
 private int number;
 private int index;
 
//changes last line to return true when numbers in
	//the hashSet are duplicated 
 
 @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		return number == other.number;
	}
 
//changed to ust number, instead of number and index 
	//this way the same hash code is assigned to objects with 
	//the same number
 @Override
	public int hashCode() {
		return Objects.hash(number);
	}
}

//
//Write a program that will accept 10 numbers from the user as input and store it in a collection.
//The numbers should not be duplicated. Also get the index position along with the number where it has to be stored.