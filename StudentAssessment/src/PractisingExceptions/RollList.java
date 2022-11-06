package PractisingExceptions;



public class RollList {

	private Student[] rollList; //array of student's rollments
	private int totalRoll;
	
	
	public RollList(int totalRoll) {
		super();
		this.totalRoll = totalRoll;
		rollList = new Student[totalRoll];
	}
	
	//method to check the number of rolls
	public void inputRollNo(Student student, int index) throws RollNoException{
		for (int i = 0; i < index; i++) {
			if (rollList[i].getRollNo() == (student.getRollNo())) {
                	throw new RollNoException ("Duplicate Roll Number entered.");
			}
		}
			
			rollList[index] = student;
		}
	
	
	//display method
	public void displayRollNo() {
		for (Student stud : rollList) {
			stud.displayStudent();
		}
	}
	
}
