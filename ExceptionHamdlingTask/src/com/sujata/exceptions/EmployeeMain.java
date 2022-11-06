package com.sujata.exceptions;

import java.util.Scanner;

public class EmployeeMain {
    
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	
	try {
	EmployeeList employeelist;

	System.out.println("Please enter how many people you have");
	int total = scanner.nextInt();
	
	employeelist = new EmployeeList(total);
	
	
	for(int index = 0; index < total; index++) {
		
		Employee emp = new Employee();
		
		System.out.println("Please enter the name of the employee: ");
		emp.setName(scanner.next());
		
		System.out.println("Please enter the age of the employee: ");
		emp.setAge(scanner.nextInt());
		
		employeelist.inputEmployee(emp, index);
	}
	
	employeelist.displayEmployeeList();
	
	} catch (AgedCheckedException exception) {
		System.out.println(exception.getMessage());
	} catch (NameCheckedException exception) {
		System.out.println(exception.getMessage());
	} catch (NegativeArraySizeException e) {
		System.out.println("Total No of employee cannot be negative");
	} catch (Exception e) {
		System.out.println("OOPS Something went wrong, please try after sometime!");
	}
	
}
}