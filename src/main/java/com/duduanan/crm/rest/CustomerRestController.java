package com.duduanan.crm.rest;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/customers/{customerId}")
	public Customer customer(@PathVariable int customerId){
		Customer customer=customerservice.getCustomer(customerId);
		if(customer==null){
			throw new CustomerNotFoundException("customer id not found - "+ customerId);
		}
		return customer;
	}
	/**
	 * Create Customer API
	 * Method:POST
	 * @param customer
	 * @return Customer
	 */
	  @PostMapping("customers")
	public Customer customer(@RequestBody Customer customer){
		customer.setId(0);
		customerservice.saveCustomer(customer);	
		return customer;
	}
	
}
