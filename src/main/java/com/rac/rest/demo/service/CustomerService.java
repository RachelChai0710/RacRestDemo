package com.rac.rest.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rac.rest.demo.data.Address;
import com.rac.rest.demo.data.Customer;
import com.rac.rest.demo.repository.CustomerRepository;

/**
 * Service class for managing customer-related operations.
 */
@Service
@Transactional
public class CustomerService{

	/** Customer Repository */
	@Autowired
	CustomerRepository customerRepository;
	
	/** Address Service */
	@Autowired
	AddressService addressService;
	
	/**
	 * Retrieves all customers from the database.
	 * @return List of all customers.
	 */
	public List<Customer> findAll() {		
		return  customerRepository.findAll();
	}
	
	/**
	 * Retrieves a customer by ID from the database.
	 * @param id The ID of the customer to retrieve.
	 * @return The customer if found, otherwise null.
	 */
	public Customer findById(long id) {
		return customerRepository.findById((long)id).orElse(null);
	}
	
	/**
	 * Adds a new customer to the database.
	 * @param cus The customer to add.
	 * @return The added customer.
	 * @throws Exception If an error occurs during the addition process.
	 */
	public Customer add(Customer cus) throws Exception {
		Address adr = cus.getAddress();
		
		if(null != adr) {
			addressService.addOrUpdate(adr);
		}
		return customerRepository.save(cus);
	}
	
	/**
	 * Updates an existing customer in the database.
	 * @param cus The customer to update.
	 * @return The updated customer.
	 * @throws Exception If an error occurs during the update process.
	 */
	public Customer update(Customer cus) throws Exception {
		Address adr = cus.getAddress();
		
		if(null != adr) {
			addressService.addOrUpdate(adr);
		}
		return customerRepository.save(cus);
	}
	
	/**
	 * Deletes a customer from the database.
	 * @param cus The customer to delete.
	 */
	public void delete(Customer cus) {
		Address adr = cus.getAddress();
		customerRepository.delete(cus);
		if(null != adr) {
			addressService.delete(adr);
		}
	}
}
