package com.ms.customer.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.model.CustomCustomer;

@RestController
@RequestMapping("/rest/api/customers")
public class CustomerRestController {

	static Map<Integer, CustomCustomer> customerList;
	
	static {
		customerList = new HashMap<>();
		customerList.put(1, new CustomCustomer(1, "John"));
		customerList.put(2, new CustomCustomer(2, "Kerry"));
		customerList.put(3, new CustomCustomer(3, "Mathew"));
		customerList.put(4, new CustomCustomer(4, "Georgi"));
	}
	
	@Value("${welcome.message}")
	String welcomeTest;

	@RequestMapping("/greet")
	public String testMethod() {
		return welcomeTest;
	}
	@GetMapping(value = "/{name}")
	public CustomCustomer getCustomerByName(@PathVariable final String name) {
		Iterator<Map.Entry<Integer, CustomCustomer>> iterator = customerList.entrySet().iterator();
		while (iterator.hasNext()) {
			CustomCustomer customer = (CustomCustomer)iterator.next().getValue();
			if (customer.getName().equals(name))
				return customer;
		}
		return null;
	}

}
