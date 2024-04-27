package com.rac.rest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rac.rest.demo.data.Address;
import com.rac.rest.demo.repository.AddressRepository;

/**
 * Service class for managing address-related operations.
 */
@Service
public class AddressService {
	
	/** Address Repository */
	@Autowired
	AddressRepository addressRepository;
	
	/**
	 * Adds or updates an address in the database.
	 * @param adr The address to add or update.
	 * @return The added or updated address.
	 * @throws Exception If the address is not valid or an error occurs during database operation.
	 */
	public Address addOrUpdate(Address adr) throws Exception {
		isValid(adr);
		return addressRepository.save(adr);
	}
	
	/**
	 * Deletes an address from the database.
	 * @param adr The address to delete.
	 */
	public void delete(Address adr) {
		addressRepository.delete(adr);
	}
	
	/**
	 * Validates the address fields.
	 * @param adr The address to validate.
	 * @throws Exception If any required field is missing in the address.
	 */
	private void isValid(Address adr) throws Exception {
		if(null == adr.getAdrLine1()) {
			throw new Exception("Address Line 1 is required!");
		}
		if(null == adr.getPostcode()) {
			throw new Exception("Postcode is required!");
		}
		if(null == adr.getState()) {
			throw new Exception("State is required!");
		}
		if(null == adr.getCountry()) {
			throw new Exception("Country is required!");
		}
	}
}
