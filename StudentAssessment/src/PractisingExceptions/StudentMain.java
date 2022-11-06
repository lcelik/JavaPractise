package PractisingExceptions;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) throws RollNoException, AgeException, MarksException {
	
	Scanner scanner = new Scanner(System.in);
	
	try {
	RollList rollList;
	
	System.out.println("Please enter how many students you have");
	int total = scanner.nextInt();
	
	 rollList = new RollList(total);
	 
	
	 
	 for(int index = 0; index < total; index++) {
		 
	 Student student = new Student();
	 
	 System.out.println("Please enter the Student's Roll Number: ");
		student.setRollNo(scanner.nextInt());
		
		 System.out.println("Please enter the Student's Name: ");
			student.setName(scanner.next());
			
			 System.out.println("Please enter the Student's Age: ");
			 student.setAge(scanner.nextInt());
			 
			 System.out.println("Please enter the Student's marks: ");
			 student.setMarks(scanner.nextInt());
			 
			 rollList.inputRollNo(student, index);
	 }
	 
	 rollList.displayRollNo();
	} catch (RollNoException exception) {
		System.out.println(exception.getMessage());
	} catch (AgeException exception) {
		System.out.println(exception.getMessage());
	} catch (MarksException exception) {
		System.out.println(exception.getMessage());
	} catch (NegativeArraySizeException e) {
		System.out.println("Total No of employee cannot be negative");
	} catch (Exception e) {
		System.out.println("OOPS Something went wrong, please try after sometime!");
	}
}
}