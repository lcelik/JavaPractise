package persistence;

import java.util.Collection;

import entity.Employee;

/*
 * DAO : Data Access Object : Design Pattern to design persistence layer
 */
public interface EmployeeDao {

	Collection<Employee> getAllRecords();
}
