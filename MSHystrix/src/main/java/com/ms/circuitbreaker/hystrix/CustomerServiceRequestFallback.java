package com.ms.circuitbreaker.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.customer.model.Customer;

@Component
public class CustomerServiceRequestFallback implements CustomerServiceRequest {

	@Override
	public List<Customer> getCustomerInformation() {
		List<Customer> customers = new ArrayList<Customer>();
		return customers;
	}

}
