package com.sujata.service;

import java.util.Collection;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePaySlip;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	//Service will request persistence layer for all data needs
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.searchRecord(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
//		Employee emp=employeeDao.searchRecord(employee.getEmpId());
//		if(emp!=null) {
//			return false;
//		}
//		employeeDao.insertRecord(employee);
//		return true;
		
		if(employeeDao.insertRecord(employee)>0)
			return true;
		return false;
	}
	


	@Override
	public boolean deleteEmployee(int id) {
//		Employee employee=employeeDao.deleteRecord(id);
//		if(employee!=null) {
//			return true;
//		}
//		return false;
		if(employeeDao.deleteRecord(id)>0)
			return true;
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
//		Employee employee=employeeDao.searchRecord(id);
//		if(employee==null) {
//			return false;
//		}
//		employee.setEmpSalary(employee.getEmpSalary()+increment);
//		employeeDao.insertRecord(employee);
//		return true;
		
		if(employeeDao.updateSalary(id,increment)>0)
			return true;
		return false;
	}

	/*
	 * Business Rule
	 * AllowancesA : 18% of salary
	 * AllowanceB : 12% of salary
	 * Deduction : 8% of salary
	 */
	@Override
	public EmployeePaySlip generatePaySlip(int employeeId) {
		Employee employee=employeeDao.searchRecord(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePaySlip employeePaySlip=new EmployeePaySlip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
		
	}

}
