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

	@Override
	public Customer transferFunds(int myAccountId, int savingAccountId, double amount) {
		
		Customer customer = customerDao.findById(myAccountId).get();
		
		    if (customer.getCustomerBalance()<amount) {  //if account doesn't have the sufficient amount
			    return null;
			    
		  }	else {
				Customer savingRecepient = customerDao.findById(savingAccountId).orElse(null);
				
				if (savingRecepient!=null) {
					
					savingRecepient.setCustomerBalance(savingRecepient.getCustomerBalance()+amount); //adding the amount to saving account
					customer.setCustomerBalance(customer.getCustomerBalance()-amount);   //taking amount from customer account
					
					customerDao.save(savingRecepient);   //save and update in database
					customerDao.save(customer);
					
					return customer;
				}
				else
					return null;
			}
		
	}
	
	
}
