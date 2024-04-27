package com.rac.rest.demo.rest;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.rest.demo.data.Address;
import com.rac.rest.demo.data.AddressReq;
import com.rac.rest.demo.data.Customer;
import com.rac.rest.demo.data.CustomerReq;
import com.rac.rest.demo.service.CustomerService;

import io.micrometer.common.util.StringUtils;

/**
 * Controller class for handling customer-related HTTP requests.
 * Extends {@link BaseController} to inherit common functionality, 
 */
@RestController
@RequestMapping("/cus")
public class CustomerController extends BaseController{	
	
	/** Customer Service */
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Sets the logger for this controller.
	 */
	@Override
	protected void setLogger() {
		this.log = LoggerFactory.getLogger(CustomerController.class);
	}
	
	/**
	 * Handles HTTP GET request to retrieve all customers.
	 * @return ResponseEntity containing the list of customers or an error message.
	 */
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllCustomers(){
		this.logReqNRes("{}", REQ);
		List<Customer> customers = customerService.findAll();
		if(null == customers || CollectionUtils.isEmpty(customers)) {			
			return getRes("No customer in database", HttpStatus.NOT_FOUND, true);
		}
		
		return getRes(customers, HttpStatus.OK, false);
	}
	
	/**
	 * Handles HTTP GET request to retrieve a customer by ID.
	 * @param id The ID of the customer to retrieve.
	 * @return ResponseEntity containing the customer or an error message if not found.
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id){
		Customer cus = customerService.findById((long)id);
		if(null == cus) {
			return getRes("Cannot find customer with id:" + id, HttpStatus.NOT_FOUND, true);
		}
		return getRes(cus, HttpStatus.OK, false);
	}
	
	/**
	 * Handles HTTP PUT request to update a customer.
	 * @param id The ID of the customer to update.
	 * @param req The request body containing the updated customer data.
	 * @return ResponseEntity containing the updated customer or an error message.
	 */
	@PutMapping("/upd/{id}")
	public ResponseEntity<Object> updCus(@PathVariable("id") int id, @RequestBody CustomerReq req){
		this.logReqNRes(req, REQ);
		Customer cus = customerService.findById((long)id);
		if(null == cus) {
			return getRes("Cannot find customer with id:" + id, HttpStatus.NOT_FOUND, true);
		}
		if(StringUtils.isNotBlank(req.getName())) {
			cus.setName(req.getName());
		}
		if(0 != req.getAge()) {
			cus.setAge(req.getAge());
		}
		AddressReq adrReq = req.getAdr();
		if(null != adrReq) {
			Address adr = cus.getAddress();
			if(null == adr) {
				adr = new Address();
			}
			if(StringUtils.isNotBlank(adrReq.getAdrLine1())) {
				adr.setAdrLine1(adrReq.getAdrLine1());
			}
			if(StringUtils.isNotBlank(adrReq.getCountry())) {
				adr.setCountry(adrReq.getCountry());
			}
			if(StringUtils.isNotBlank(adrReq.getPostcode())) {
				adr.setPostcode(adrReq.getPostcode());
			}
			if(StringUtils.isNotBlank(adrReq.getState())) {
				adr.setState(adrReq.getState());
			}
			adr.setAdrLine2(adrReq.getAdrLine2());

			cus.setAddress(adr);
		}
		
		try {
			customerService.update(cus);
		} catch (Exception e){
			return getRes(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, true);
		}
		this.logReqNRes(cus, RES);
		return  getRes(cus, HttpStatus.OK, false);
	}
	
	/**
	 * Handles HTTP POST request to add a new customer.
	 * @param req The request body containing the customer data.
	 * @return ResponseEntity containing the added customer or an error message.
	 */
	@PostMapping("/add")
	public ResponseEntity<Object> addCus(@RequestBody CustomerReq req){
		this.logReqNRes(req, REQ);
		if (req.getName() == null || req.getName().isEmpty()) {
            return getRes("Name is required", HttpStatus.BAD_REQUEST, true);
        }
		
		AddressReq adrReq = req.getAdr();
		Address adr = null;
		if(null != adrReq) {
			adr = new Address(adrReq.getAdrLine1(), adrReq.getAdrLine2(),
					adrReq.getPostcode(), adrReq.getState(), adrReq.getCountry());
		}
		
		Customer savedCustomer;
		try {
			savedCustomer = customerService.add(new Customer(req.getName(), req.getAge(), adr));
		} catch (Exception e){
			return getRes(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, true);
		}
        return  getRes(savedCustomer, HttpStatus.CREATED, false);
	}
	/**
	 * Handles HTTP DELETE request to delete a customer by ID.
	 * @param id The ID of the customer to delete.
	 * @return ResponseEntity indicating success or failure of the deletion operation.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCus(@PathVariable("id") int id){
		Customer cus = customerService.findById((long)id);
		if(null == cus) {
			return getRes("Cannot find customer with id:" + id, HttpStatus.NOT_FOUND, true);
		}
		try {
			customerService.delete(cus);
		} catch (Exception e){
			return getRes(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, true);
		}
       
        return  getRes("Customer deleted successfully!", HttpStatus.OK, false);
	}	
}
