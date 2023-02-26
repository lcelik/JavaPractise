package com.lidija.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidija.entity.Customer;
import com.lidija.model.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer loginCheck(int id, String password) {
		
		try {
	   Customer customer = customerDao.findCustomerByAccountIdAndCustomerPassword(id, password);
	   return customer;
	   
		}catch (Exception exception) {
		 return null;
	   }
	 
	}
	
	
}
