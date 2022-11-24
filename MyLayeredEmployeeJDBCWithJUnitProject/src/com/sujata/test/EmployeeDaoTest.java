package com.sujata.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sujata.entity.Employee;
import com.sujata.persistence.EmployeeDaoImpl;
import com.sujata.service.EmployeeServiceImpl;

class EmployeeDaoTest {
	
	
	 EmployeeDaoImpl employeeDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		employeeDaoImpl=new EmployeeDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeDaoImpl=null;
	}

	@Test
	void testGetAllRecords() {
		assertTrue(employeeDaoImpl.getAllRecords().size()>0);
	}

//	@Test
//	void testSearchRecord() {
//		fail("Not yet implemented");
//	}

	@Test
	void testInsertRecord() {
		assertEquals(1, employeeDaoImpl.insertRecord(new Employee(110,"HHHG","Executive","Sales",45000,LocalDate.now())));
	}

//	@Test
//	void testDeleteRecord() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateSalary() {
//		fail("Not yet implemented");
//	}

}
