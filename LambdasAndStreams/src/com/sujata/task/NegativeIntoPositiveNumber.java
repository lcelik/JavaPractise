package com.sujata.task;

import java.util.Arrays;
import java.util.List;

public class NegativeIntoPositiveNumber {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(-10, -5, -3, -25, -4, 8, 9, 10);
		
		numbers.stream().filter(n -> n <= 0).map(e -> e * -1).forEach(e -> System.out.println(e));
		
	}
}
