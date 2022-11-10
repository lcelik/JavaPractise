package com.sujata.hashmaps;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class NumbersMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//declare LinkedHashSet
		Set<Number> numbers = new LinkedHashSet<Number>();
		
        System.out.println("Create a collection of 10 numbers");
		
        //create ArrayList to store used numbers
        List<Integer> usedNumbers = new ArrayList<Integer>(10);
        
        for (int i = 0; i < 10; i++) {
        	System.out.println("Please enter the number");
        	int userNum = scanner.nextInt();
        	
        	//create number object with index i
        	Number number = new Number(userNum, i);
        
        	
        	//check for duplicate numbers
        	if (usedNumbers.contains(userNum)) {
        		System.out.println("That number is already in the set!");
        		
        	} else {
        		
        		usedNumbers.add(userNum); //adding user number to arrayList
        		
        		//add number object to LinkedHashSet
        		numbers.add(number);
        	}
        }
        //display LinkedHashSet of numbers and indexes
        for (Number n: numbers) {
        	System.out.println(n);
        }
	}

}

//another way
//hashMap
//		Set<Numbers> numbCollection = new HashSet<Numbers>();

//user prompts
//		System.out.println("entering 10 numbers");
//		
//		for(int i=0; i<10; i++) {
//			System.out.println("Please enter " + (i+1) + " number : ");
//			numbCollection.add(new Numbers(i, sc.nextInt()));		
//		}
//		
//		//now displaying the hashSet via iterator 
//		Iterator<Numbers> iterator = numbCollection.iterator();
//		
//		//no duplicates displayed 
//		System.out.println("collection of numbers with no duplicates:");
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//		
//		int numbSize = numbCollection.size();
//		
//		//CAN USE getNumber() TO CHECK IF the number is in the hashList 
//		//GETNUMB IS FROM LOMBOK
//		//can get to 10 elements by using size()
//		System.out.println("There are " + numbSize +
//				" numbers in the collection, add " + (10-numbSize) + 
//				" more unique numbers:");
//		
//		int i=10;
//		while(numbCollection.size() < 10) {
//			numbSize = numbCollection.size();
//			System.out.println("Please enter " + (numbSize+1) +
//					" number: "); 
//			numbCollection.add(new Numbers(i+1, sc.nextInt()));
//			i++;
//		}
//		
//		System.out.println("The collection of 10 numbers: ");
//		//displaying all 10 numbers
//		for(Numbers numbs:numbCollection) {
//			System.out.println(numbs);
//		}
