package com.rac.rest.demo.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Address Entity Class
 */
@Entity
@Table(name="ADDRESS")
public class Address {
	
	/**
	 * Address ID. 
	 * Primary Key
	 */
	@Id
	@Column(name = "ADR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adrId; 
	
	/**
	 * Address Line 1. 
	 * Non-nullable field.
	 */
	@Column(name = "ADR_LINE_1", nullable=false)
	private String adrLine1;
	
	/**
	 * Address Line 2. 
	 */
	@Column(name = "ADR_LINE_2")
	private String adrLine2;
	
	/**
	 * Postal Code. 
	 * Non-nullable field. 
	 */
	@Column(nullable=false)
	private String postcode;
	
	/**
	 * State. 
	 * Non-nullable field. 
	 */
	@Column(nullable=false)
	private String state;
	
	/**
	 * Country. 
	 * Non-nullable field. 
	 */
	@Column(nullable=false)
	private String country;
	
	/**
     * Default constructor.
     */
	public Address() {
		
	}
	
	/**
	 * Constructs a new Address with the specified address details.
	 *
	 * @param adrLine1 the first line of the address
	 * @param adrLine2 the second line of the address
	 * @param postcode the postal code of the address
	 * @param state the state or region of the address
	 * @param country the country of the address
	 */
	public Address(String adrLine1, String adrLine2, String postcode, String state, String country) {
	    super();
	    this.adrLine1 = adrLine1;
	    this.adrLine2 = adrLine2;
	    this.postcode = postcode;
	    this.state = state;
	    this.country = country;
	}

	/**
	 * Returns the address ID.
	 *
	 * @return the address ID
	 */
	public long getAdrId() {
	    return adrId;
	}

	/**
	 * Sets the address ID.
	 *
	 * @param adrId the address ID to set
	 */
	public void setAdrId(long adrId) {
	    this.adrId = adrId;
	}

	/**
	 * Returns the first line of the address.
	 *
	 * @return the first line of the address
	 */
	public String getAdrLine1() {
	    return adrLine1;
	}

	/**
	 * Sets the first line of the address.
	 *
	 * @param adrLine1 the first line of the address to set
	 */
	public void setAdrLine1(String adrLine1) {
	    this.adrLine1 = adrLine1;
	}

	/**
	 * Returns the second line of the address.
	 *
	 * @return the second line of the address
	 */
	public String getAdrLine2() {
	    return adrLine2;
	}

	/**
	 * Sets the second line of the address.
	 *
	 * @param adrLine2 the second line of the address to set
	 */
	public void setAdrLine2(String adrLine2) {
	    this.adrLine2 = adrLine2;
	}

	/**
	 * Returns the postal code of the address.
	 *
	 * @return the postal code of the address
	 */
	public String getPostcode() {
	    return postcode;
	}

	/**
	 * Sets the postal code of the address.
	 *
	 * @param postcode the postal code of the address to set
	 */
	public void setPostcode(String postcode) {
	    this.postcode = postcode;
	}

	/**
	 * Returns the state or region of the address.
	 *
	 * @return the state or region of the address
	 */
	public String getState() {
	    return state;
	}

	/**
	 * Sets the state or region of the address.
	 *
	 * @param state the state or region of the address to set
	 */
	public void setState(String state) {
	    this.state = state;
	}

	/**
	 * Returns the country of the address.
	 *
	 * @return the country of the address
	 */
	public String getCountry() {
	    return country;
	}

	/**
	 * Sets the country of the address.
	 *
	 * @param country the country of the address to set
	 */
	public void setCountry(String country) {
	    this.country = country;
	}
}
