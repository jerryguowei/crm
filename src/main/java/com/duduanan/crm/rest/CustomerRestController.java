package com.duduanan.crm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duduanan.crm.entity.Customer;
import com.duduanan.crm.service.CustomerService;
@RestController
@RequestMapping("api")
public class CustomerRestController {
	@Autowired
	CustomerService customerservice;
	@GetMapping("/customers")
	public List<Customer> customers(){
		
		return  customerservice.getCustomers();
	}

}
