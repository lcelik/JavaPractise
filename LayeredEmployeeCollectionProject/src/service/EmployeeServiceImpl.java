package service;

import java.util.Collection;

import entity.Employee;
import persistence.EmployeeDao;
import persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public Collection<Employee> getallEmployees() {
		
		return employeeDao.getAllRecords();
	}

}
