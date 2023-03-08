package com.lidija.controller;


//import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lidija.entity.Customer;
import com.lidija.model.service.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView getLoginPageController() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginController(@RequestParam("accountId")int id, @RequestParam("pwd")String password, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Customer customer = customerService.loginCheck(id, password);
		
		if(customer != null) {
			session.setAttribute("customer", customer);  //putting customer on session
			modelAndView.setViewName("TransactionPage");
		}
		else {
			modelAndView.addObject("message", "Login Failed, Please try again");
			modelAndView.setViewName("index");
		}
		
		return modelAndView;
		
	}
	
//	@RequestMapping("/customerList")
//	public ModelAndView getAllCustomersController(Customer customer, HttpSession session)  {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		
//		return new ModelAndView;
//	}
//	
	
	
//	@RequestMapping("/register")
//	public ModelAndView registerController(@ModelAttribute("customer") Customer customer,HttpSession session) {
//		ModelAndView modelAndView=new ModelAndView();
//		
//		Customer customer = customerService.registerCustomer(customer);
//		
//		if(customer == null) {
//			modelAndView.addObject("message", "Registration failed");  
//			session.setAttribute("customer", customer);  //data is set on session scope i.e data available in multiple request and response cycles
//			
//		}
//		else {
//			modelAndView.addObject("message", " You have succsesfully registered");
//			modelAndView.addObject("customer", new Customer());
//			modelAndView.setViewName("Output");
//		}
//			
//		return modelAndView;
//	}
	
	
//	  @PostMapping(path = "/register", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public String registerCustomerResource(@RequestBody Customer customer) throws SQLIntegrityConstraintViolationException {
//	        try {
//	           Customer result = customerService.registerCustomer(customer);
//	            if (result == null)
//	                return "User was not added.";
//	            else
//	                return "User successfully added.";
//	        } catch (SQLIntegrityConstraintViolationException e) {
//	            return "User was not added.";
//	        }
	
    @RequestMapping("/transferFunds")
    public ModelAndView transferFundsController(@RequestParam("accountId")int savingAccountId, @RequestParam("amount")double amount, HttpSession session) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	int myAccountId = ((Customer)session.getAttribute("customer")).getAccountId();
    	
    	Customer customer = customerService.transferFunds(myAccountId, savingAccountId, amount);
    	
    	if (customer == null) {
    		modelAndView.addObject("message", "Transaction Failed");
    	    session.setAttribute("customer", customer); //l updated the session with the customer update(with the new balance)
    	    
    	}	else 
    		
    		modelAndView.addObject("message", "Your account has been debited with the amount " + amount + " and credited in Saving Account No " +
    	savingAccountId + " and your current balance is " + customer.getCustomerBalance());
    	
    	modelAndView.setViewName("Output");
    	
    	return modelAndView;
    }
}
