package com.lidija.model.service;

import com.lidija.entity.Customer;

public interface CustomerService {

	
	//Customer Object
	Customer loginCheck(int id, String password);
	
	Customer transferFunds(int myAccountId, int savingAccountId, double amount);
}
