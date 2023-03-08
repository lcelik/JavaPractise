package com.lidija.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lidija.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	//creating a query with the help of naming convention
	
	public Customer findCustomerByAccountIdAndCustomerPassword(int id, String password);
	
	public Customer getCustomerByCustomerName(String customerName);
	
	

}
