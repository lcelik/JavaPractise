package com.sujata.treeset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee implements Comparable<Employee> {
	

private int employeeId;
private String name;
private String designation;
private String department;
private int salary;
private int yearsOfExperience;

/*
 * TreeSet will be using compareTo to arrange objects in ascending order and will store unique
 * if object1 (this) is greater return :1
 * if object2(argument) is greater return : -1
 * if both objects are equal : 0
 */
@Override
public int compareTo(Employee employee2) {
	if(yearsOfExperience > employee2.yearsOfExperience) {
		return 1;
	} else if (yearsOfExperience < employee2.yearsOfExperience) {
		return -1;
	} else if (this.equals(employee2)) {
		return 0;
	}
	return 1;
}
}


//Create a tree set
//and sort by years of experience