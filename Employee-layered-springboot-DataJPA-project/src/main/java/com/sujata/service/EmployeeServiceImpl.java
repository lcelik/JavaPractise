package com.sujata.service;

import java.util.Collection;

//import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePaySlip;
import com.sujata.persistence.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
//		if(employeeDao.insertRecord(employee)>0)
		
		if(searchEmployeeById(employee.getEmpId()) == null) {
			
			// save means : save and update
			employeeDao.save(employee);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
//		if(employeeDao.deleteRecord(id)>0)
		
		if (searchEmployeeById(id) != null) {
			
			employeeDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
//		if(employeeDao.updateSalary(id,increment)>0)
		
		Employee employee = searchEmployeeById(id);
		
		if(employee!=null) {
			employee.setEmpSalary(employee.getEmpSalary() + increment);
			employeeDao.save(employee);
			return true;
		}
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
		
		Employee employee = searchEmployeeById(employeeId);
		
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePaySlip employeePaySlip = new EmployeePaySlip(employee, allowanceA, allowanceB, deduction,totalSalary);
			
			return employeePaySlip;
		}
		return null;
		
	}
}
