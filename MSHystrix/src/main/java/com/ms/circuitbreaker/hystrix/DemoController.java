package com.ms.circuitbreaker.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.customer.model.Customer;

@RestController
public class DemoController {

	@Autowired
	private HystrixImpl hystrixImpl;

	ResponseEntity<String> exchange = null;
	
	ResponseEntity<Customer> customerResponse = null;

	@RequestMapping("/greet")
	public String getAccounts() {
		try {
			exchange = hystrixImpl.greet();
			return exchange.getBody() + "::status code :" + exchange.getStatusCode();
		} catch (Exception e) {
		}
		return "";
	}
	
	
	@GetMapping("/rest/api/customers/{name}")
	public Customer getCustomerById(@PathVariable final String name) {
		/*customerResponse = hystrixImpl.getCustomerDetails(name);
		return (Customer)customerResponse.getBody();*/
		return hystrixImpl.getCustomerDetails(name);
	}
}
