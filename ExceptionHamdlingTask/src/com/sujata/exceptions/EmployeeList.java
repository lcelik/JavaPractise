package com.sujata.exceptions;

//import com.sujata.arrays.Person;

public class EmployeeList {

	private Employee[] empList; //array of employees
	private int totalNoOfEmployees;
	
	
	public EmployeeList(int totalNoOfEmployees) {
		super();
		this.totalNoOfEmployees = totalNoOfEmployees;
		empList = new Employee[totalNoOfEmployees];
	}
	
	public void inputEmployee(Employee employee, int index) throws NameCheckedException {
		
		for ( int i = 0; i < index; i++) {
			if (empList[i].getName().equals(employee.getName())) {
				throw new NameCheckedException("Duplicate name entered");
			}
		}

		empList[index] = employee;
	}
	
	
	public void displayEmployeeList() {
		
		/*
		 * for each for(datatype variable:array/anycollection){ statements; }
		 */
		for (Employee emp : empList) {
			emp.display();

		}
	}
}




