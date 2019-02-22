/*package com.ms.circuitbreaker.hystrix;

import java.net.URI;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ms.customer.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HystrixImpl {

	@Autowired
	RestTemplate restTemplate;


	@HystrixCommand(fallbackMethod = "defaultFallBackCallGreet")
	public ResponseEntity<String> greet() {
		System.out.println("----------inside man------------");
		URI endPoint = URI.create("http://localhost:8082/greet");
		return restTemplate.getForEntity(endPoint, String.class);
	}

	public ResponseEntity<String> defaultFallBackCallGreet() {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@HystrixCommand(fallbackMethod  = "defaultFallBackCallGetCustomerDetails")
	public Customer getCustomerDetails(String name) {
		URI endPoint = URI.create("http://localhost:8082/rest/api/customers/"+name);
		Map<String,String> params = new HashedMap();
		params.put("name", name);
		Customer customer = restTemplate.getForObject(endPoint.toString(),Customer.class,params);
		System.out.println(customer.getName()+"+++++++++++++");
		return customer;
	}
	
	public Customer defaultFallBackCallGetCustomerDetails(String name) {
		return new Customer(0,"not found");
	}
}
*/