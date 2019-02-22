package com.ms.customer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ms.customer.model.Customer;

@Repository
public class CustomerDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL = "select * from customers";
	
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = new ArrayList<Customer>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
		
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			
			customer.setCustNo(Integer.valueOf(String.valueOf(row.get("Cust_id"))));
			customer.setCustName((String)row.get("Cust_name"));
			customer.setCountry((String)row.get("Country"));
			
			customers.add(customer);
		}

		return customers;
		
	}

}
