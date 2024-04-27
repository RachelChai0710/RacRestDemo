package com.rac.rest.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Address Request Details.
 */
public class CustomerReq extends BaseReq{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4902977407313695010L;

	/** Customer's Name. */
	@JsonProperty("name")
	private String name;
	
	/** Customer's Age. */
	@JsonProperty("age")
	private int age;
	
	/** Customer's Address. */
	@JsonProperty("address")
	private AddressReq adr;
	
	/**
     * Returns the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the name of the customer to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the customer.
     *
     * @return the age of the customer
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     *
     * @param age the age of the customer to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the address of the customer.
     *
     * @return the address of the customer
     */
	public AddressReq getAdr() {
		return adr;
	}

	/**
     * Sets the address of the customer.
     *
     * @param address the address of the customer to set
     */
	public void setAdr(AddressReq adr) {
		this.adr = adr;
	}
}
