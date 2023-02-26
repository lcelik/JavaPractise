package com.lidija.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	

}
