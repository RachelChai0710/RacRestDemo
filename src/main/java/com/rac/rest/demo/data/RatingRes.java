package com.rac.rest.demo.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingRes implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3036249417809793228L;

	/** Product's Rate */
	@JsonProperty("rate")
	private double rate;
	
	/** Product's Count */
	@JsonProperty("count")
	private int count;

	/**
	 * Retrieves the rate of the product.
	 * 
	 * @return The rate of the product.
	 */
	public double getRate() {
	    return rate;
	}

	/**
	 * Sets the rate of the product.
	 * 
	 * @param rate The rate of the product.
	 */
	public void setRate(double rate) {
	    this.rate = rate;
	}

	/**
	 * Retrieves the count of the product.
	 * 
	 * @return The count of the product.
	 */
	public int getCount() {
	    return count;
	}

	/**
	 * Sets the count of the product.
	 * 
	 * @param count The count of the product.
	 */
	public void setCount(int count) {
	    this.count = count;
	}
}
