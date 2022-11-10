package persistence;

import java.util.Collection;

import database.EmployeeDataBase;
import entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Collection<Employee> getAllRecords() {
		 return EmployeeDataBase.getEmployeeList().values();
	}

}
