package com.sujata.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



public class EmployeeTreeSet {

	public static void main(String[] args) {
		/*
		 * TreeSet : unique sorted collection of values, which is auto-growable and auto-shrinkable 
		 */
		
		Set<Employee> myEmployee = new TreeSet<Employee>();
		
		System.out.println("Size :" + myEmployee.size());
		myEmployee.add(new Employee(001, "Employee1", "Manager", "Sales", 50000, 3));
		myEmployee.add(new Employee(002, "Employee2", "Developer", "IT", 70000, 4));
		myEmployee.add(new Employee(003, "Employee3", "Director", "Sales", 80000, 6));
		myEmployee.add(new Employee(004, "Employee4", "HR Manager", "HR", 65000, 5));
		
		
		System.out.println(myEmployee);
		
	    System.out.println("Traversal using for each loop");
	    for (Employee element: myEmployee) {
	    	System.out.println(element);
	    }

	    System.out.println("Traversal using Iterator");
	    Iterator<Employee> iterator = myEmployee.iterator();
	    while (iterator.hasNext()) {
	    	System.out.println(iterator.next());
	    }
	    
	}

}
