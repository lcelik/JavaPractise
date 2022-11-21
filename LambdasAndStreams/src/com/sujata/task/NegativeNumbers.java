package com.sujata.task;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NegativeNumbers {
	 public static void main(String[] args) {
	 
		 List<Integer> numbers = Arrays.asList(1, 5, -2, -1, 7, 8, -4);
		  
		 //count the number of negative numbers using lambda and stream

		  long negativeNumbers = numbers.stream().filter((c) -> c < 0).count();
		
		 System.out.println("Number of negative numbers is: " + negativeNumbers);
	 }
}
