package com.ms.circuitbreaker.hystrix;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ms.customer.model.Customer;

@FeignClient(name= "customerservice",fallback = CustomerServiceRequestFallback.class)
public interface CustomerServiceRequest {

	@GetMapping("/rest/api/platform/customers/all")
	List<Customer> getCustomerInformation();
}
