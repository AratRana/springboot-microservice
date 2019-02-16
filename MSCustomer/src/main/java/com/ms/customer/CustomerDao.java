package com.ms.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ms.customer.model.Customer;

@Service
public class CustomerDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL = "select * from customers";
	
	public List<Customer> getCustomerData() {
		
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
