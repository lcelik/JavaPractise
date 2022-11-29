package com.sujata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sujata.service.GreetingService;

//@Controller is used to mark any class as controller
@Controller
public class GreetingsController {
	
	@Autowired
	private GreetingService greetingService;
	
	//Mapping Handler
	@RequestMapping("/morning")
	//all controller methods must be public
	public ModelAndView myMorningController() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String greetMessage = greetingService.morning();
		
		//Setting data for viewing on view
		modelAndView.addObject("message", greetMessage);
		
		//Setting view name with is supposed to display output to the client
				modelAndView.setViewName("Greet");
				return modelAndView;
	}
	
	
	//Mapping Handler
	@RequestMapping("/evening")
	//all controller methods must be public
	public ModelAndView myEveningController() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String greetMessage = greetingService.evening();
		
		//Setting data for viewing on view
		modelAndView.addObject("message", greetMessage);
		
		//Setting view name with is supposed to display output to the client
				modelAndView.setViewName("Greet");
				return modelAndView;
	}

}
