package com.ms.customer.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerUICoctroller {
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
}
