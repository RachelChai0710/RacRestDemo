package com.rac.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.demo.data.Customer;
import com.rac.demo.data.CustomerReq;

@RestController
@RequestMapping("/cus")
public class CustomerRestController {

	Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<>();
		
		return customers;
	}
	
	@PutMapping("/upd/{id}")
	public List<Customer> updCus(@PathVariable int id, CustomerReq req){
		List<Customer> customers = new ArrayList<>();
		
		return customers;
	}
	
	@PostMapping("/add")
	public List<Customer> addCus(CustomerReq req){
		List<Customer> customers = new ArrayList<>();
		
		return customers;
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Customer> deleteCus(@PathVariable int id){
		List<Customer> customers = new ArrayList<>();
		
		return customers;
	}
}
