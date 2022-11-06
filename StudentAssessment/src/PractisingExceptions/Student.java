package PractisingExceptions;

public class Student {

	private int rollNo;
	private String Name;
	private int age;
	private int marks;
	
	Student() {
		
	}

	public Student(int rollNo, String name, int age, int marks) throws AgeException {
        //exception if the age is negative or less than 4 or greater than 18 
		if (age > 4 && age < 18) {
			
			this.rollNo = rollNo;
			Name = name;
			this.age = age;
			this.marks = marks;
			
		} else throw new AgeException ("Age must be between 4 and 18.");
		
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) throws RollNoException {
		this.rollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeException {
		//exception if the age is negative or less than 4 or greater than 18 
		if (age > 4 && age < 18) {
		this.age = age;
		}  else throw new AgeException ("Age must be between 4 and 18.");
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) throws MarksException {
		if (marks > 0 && marks < 100) {
			this.marks = marks;
		} else throw new MarksException ("Marks must be between 0 and 100.");
		
	}
	
	public void displayStudent() {
		System.out.println("Student RollNo: " + rollNo);
		System.out.println("Student Name: " + Name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Marks: " + marks);
		
	}
}



//Create a class called Student which asks the user to input the rollNo, name ,age ,marks of a Student.
//Raise a custom defined exception when the user enters a student rollNo
//that has been already entered and raise another exception if the age is negative or less
//than 4 or greater than 18 and one more exception if the marks is negative or greater than 100.

