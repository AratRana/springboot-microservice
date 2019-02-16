package com.ms.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.model.Customer;
import com.ms.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/rest/api/customers")
public class CustomerRestController {

	@Value("${welcome.message}")
	String welcomeTest;

	@RequestMapping("/greet")
	public String testMethod() {
		return welcomeTest;
	}
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/get-cust-info")
	public List<Customer> customerInformation() {
		
		List<Customer> customers = customerRepository.getCustomerData();		 
		
		return customers;
	}


}
