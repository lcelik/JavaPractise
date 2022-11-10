package cpm.sujata.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString 


public class Employee {

	private int rollNo;
	private String name;
	private int age;
	private String fatherName;
}
