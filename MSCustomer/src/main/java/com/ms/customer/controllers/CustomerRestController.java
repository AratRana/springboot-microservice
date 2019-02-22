package com.ms.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.dao.CustomerDao;
import com.ms.customer.model.Customer;
import com.ms.customer.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/rest/api/platform/customers")
public class CustomerRestController {

	@Value("${welcome.message}")
	String welcomeTest;

	@RequestMapping("/greet")
	public String testMethod() {
		return welcomeTest;
	}
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/all")
	public List<Customer> getCustomerInformation() {
		
		List<Customer> customers = customerDao.getAllCustomers();		 
		
		return customers;
	}


}
