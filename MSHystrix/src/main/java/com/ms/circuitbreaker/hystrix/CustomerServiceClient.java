package com.ms.circuitbreaker.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.customer.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerServiceClient {
	private final RestTemplate restTemplate;

	@Value("${api.zuul.url}")
	String zullUrl;

	@Autowired
	public CustomerServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod = "getDefaultAllCustomers")
	public List<Customer> getAllCustomers() {
		HttpEntity<Object> request = new HttpEntity<>(null);
		List<Customer> customers = null;
		ResponseEntity<List<Customer>> customerResponseEntity = restTemplate.exchange(
				zullUrl + "/rest/api/platform/customers/all", HttpMethod.GET, request,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		if (customerResponseEntity.getStatusCode() == HttpStatus.OK) {
			return customers = customerResponseEntity.getBody();
		}
		return customers;
	}

	@SuppressWarnings("unused")
	private List<Customer> getDefaultAllCustomers() {
		Customer customer = new Customer();
		customer.setCustNo(0);
		customer.setCustName("");
		customer.setCountry("");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		return customers;
	}
}
