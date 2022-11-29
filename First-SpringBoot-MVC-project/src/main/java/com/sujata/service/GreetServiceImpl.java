package com.sujata.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetingService {

	

	@Override
	public String morning() {
		return "Good morning";
	}

	@Override
	public String evening() {
		return "Good evening";
	}

}
