package com.sujata.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sujata.model.service.PalindromeService;

@Controller
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;
	
	@RequestMapping("/")
	public ModelAndView mainPageController() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/calculate")
	public ModelAndView calculatePalindromeController(HttpServletRequest request) {
		
		ModelAndView modelAndView=new ModelAndView();
		
		//request.getParameter() will return String
				int num=Integer.parseInt(request.getParameter("number"));
				
				int palindrome = palindromeService.getPalindrome(num);

				modelAndView.addObject("pal", palindrome);
				
				modelAndView.setViewName("Output");
				
				return modelAndView;
		
		
	}
}
