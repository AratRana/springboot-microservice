package com.ms.customer.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.customer.model.CustomCustomer;

@Controller
@RequestMapping("/nonrest/api/customers")
public class CustomCustomerCustroller {
	static Map<Integer, CustomCustomer> customerList;
	static {
		customerList = new HashMap<>();
		customerList.put(1, new CustomCustomer(1, "John"));
		customerList.put(2, new CustomCustomer(2, "Kerry"));
		customerList.put(3, new CustomCustomer(3, "Mathew"));
		customerList.put(4, new CustomCustomer(4, "Georgi"));
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public CustomCustomer getCustomerById(@PathVariable final int id, HttpServletRequest request,
			HttpServletResponse response) {
		return customerList.get(id);
	}

}
