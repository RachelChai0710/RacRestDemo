package com.rac.rest.demo.data;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Customer Entity Class
 */
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4180829695727857304L;

	/**
	 * Customer ID. 
	 * Primary Key
	 */
	@Id
	@Column(name = "CUS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cusId; 

	/**
	 * Customer's Name. 
	 * Non-nullable field.
	 */
	@Column(nullable=false)
	private String name;
	
	/**
	 * Customer's Age. 
	 */
	private int age;
	
	/**
	 * Customer's Address
	 * Foreign Key to Address Table on ADR_ID.
	 * One-to-One Relationship 
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADR_ID", referencedColumnName = "ADR_ID")
	private Address address;
	
	/**
     * Default constructor.
     */
    public Customer() {
        
    }

    /**
     * Constructs a new customer with the specified name, age, and address.
     *
     * @param name the name of the customer
     * @param age the age of the customer
     * @param address the address of the customer
     */
    public Customer(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Returns the unique identifier of the customer.
     *
     * @return the unique identifier of the customer
     */
    public long getCusId() {
        return cusId;
    }

    /**
     * Sets the unique identifier of the customer.
     *
     * @param cusId the unique identifier of the customer to set
     */
    public void setCusId(long cusId) {
        this.cusId = cusId;
    }

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
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address the address of the customer to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }   
}
