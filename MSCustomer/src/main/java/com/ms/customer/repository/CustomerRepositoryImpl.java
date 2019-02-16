package com.ms.customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ms.customer.CustomerDao;
import com.ms.customer.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getCustomerData() {
		return customerDao.getCustomerData();
	}

	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
