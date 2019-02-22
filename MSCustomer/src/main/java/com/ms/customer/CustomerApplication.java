package com.ms.customer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ms.customer.model.Customer;
import com.ms.customer.repository.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CustomerApplication {

	/*private final CustomerRepository customerRepository;

	@Autowired
	public CustomerApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}*/

	/*@PostConstruct
	public void generateTestData() {
		customerRepository
				.save(new Customer("Eberhard", "Wolff", "eberhard.wolff@gmail.com", "Unter den Linden", "Berlin"));
		customerRepository.save(new Customer("Rod", "Johnson", "rod@somewhere.com", "Market Street", "San Francisco"));
	}*/

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
