package com.duduanan.crm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duduanan.crm.entity.Customer;
import com.duduanan.crm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class MainController {
 @Autowired	
 private CustomerService customerService;	
 @GetMapping("/list")
 public String index(Model model){
	 List<Customer> customers=customerService.getCustomers();
	 model.addAttribute("customers", customers);
	 return "list-customers";
 }
 @GetMapping("/showAddForm")
 public String showAddForm(Model model){
	 Customer customer=new Customer();
	 model.addAttribute("customer", customer);
	 return "customer-form";
 }
 @GetMapping("/showFormForUpdate")
 public String showFormForUpdate(@RequestParam("customerId") int theId,Model model){
	 //get the customer
	 Customer theCustomer=customerService.getCustomer(theId);	 
	 model.addAttribute("customer",theCustomer);
	 return "customer-form";
 }
 @GetMapping("/deleteCustomer")
 public String deleteCustomer(@RequestParam("customerId") int theId){
	 
	 customerService.deleteCustomer(theId);
	 return "redirect:/customer/list";
 }
 
 @PostMapping("searchCustomer")
 public String searchCustomer(@RequestParam("theSearchName") String theSearchName,Model model){	 
	 List<Customer> customers=customerService.searchCustomer(theSearchName);
	 model.addAttribute("customers", customers);
	 return "list-customers";	 
 }
	  
 @PostMapping("/saveCustomer")
 public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
	 customerService.saveCustomer(theCustomer);
	 return "redirect:/customer/list";
	 
 }
}
