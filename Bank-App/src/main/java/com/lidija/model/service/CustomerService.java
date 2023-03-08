package com.lidija.model.service;

//import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;

import com.lidija.entity.Customer;




public interface CustomerService {

	
	//Customer Object
	Customer loginCheck(int id, String password);
	
//	Customer registerCustomer(Customer customer);
//	throws SQLIntegrityConstraintViolationException;
	
	
	public Customer getCustomerByCustomerId(String customerId);
	
//	public Customer getCustomerByCustomerName(String customerName);
	
	Collection <Customer> getAllCustomers();
	
	
//	public TransactionList getAllTransactions();
//	
//	public TransactionList getTransactionByAccountId(int accountId);
//	
	
	Customer transferFunds(int myAccountId, int savingAccountId, double amount);
	
	
	
	
}
