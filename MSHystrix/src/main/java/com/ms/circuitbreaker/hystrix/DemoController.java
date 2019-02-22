package com.ms.circuitbreaker.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.model.Customer;

@RestController
@RequestMapping(value="/api/hystrix")
public class DemoController {

	@Autowired
	private CustomerServiceClient customerServiceClient;

	@Autowired
	CustomerServiceRequest customerRequest;
	
	ResponseEntity<String> exchange = null;
	
	ResponseEntity<Customer> customerResponse = null;

	@GetMapping("/rest/api/platform/customers/all")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		//Using zuul without feign
		//customers = customerServiceClient.getAllCustomers();
		
		//using feign with zuul
		customers = customerRequest.getCustomerInformation();
		return customers;
	}
}
