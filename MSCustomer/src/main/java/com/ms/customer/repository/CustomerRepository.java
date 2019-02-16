package com.ms.customer.repository;

import java.util.List;

import com.ms.customer.model.Customer;

public interface CustomerRepository {

	List<Customer> getCustomerData();

	Object findAll();

	Object findById(long id);

}
