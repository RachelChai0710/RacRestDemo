package com.rac.rest.demo.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRes implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8490097993517029256L;

	/** Product's Title */
	@JsonProperty("title")
	private String title;
	
	/** Product's Price */
	@JsonProperty("price")
	private double price;
	
	/** Product's Description */
	@JsonProperty("description")
	private String desc;
	
	/** Product's Image */
	@JsonProperty("image")
	private String img;
	
	/** Product's category */
	@JsonProperty("category")
	private String cat;
	
	/** Product's Rating */
	@JsonProperty("rating")
	private RatingRes rating;

	/**
	 * Retrieves the title of the product.
	 * 
	 * @return The title of the product.
	 */
	public String getTitle() {
	    return title;
	}

	/**
	 * Sets the title of the product.
	 * 
	 * @param title The title of the product.
	 */
	public void setTitle(String title) {
	    this.title = title;
	}

	/**
	 * Retrieves the price of the product.
	 * 
	 * @return The price of the product.
	 */
	public double getPrice() {
	    return price;
	}

	/**
	 * Sets the price of the product.
	 * 
	 * @param price The price of the product.
	 */
	public void setPrice(double price) {
	    this.price = price;
	}

	/**
	 * Retrieves the description of the product.
	 * 
	 * @return The description of the product.
	 */
	public String getDesc() {
	    return desc;
	}

	/**
	 * Sets the description of the product.
	 * 
	 * @param desc The description of the product.
	 */
	public void setDesc(String desc) {
	    this.desc = desc;
	}

	/**
	 * Retrieves the image URL of the product.
	 * 
	 * @return The image URL of the product.
	 */
	public String getImg() {
	    return img;
	}

	/**
	 * Sets the image URL of the product.
	 * 
	 * @param img The image URL of the product.
	 */
	public void setImg(String img) {
	    this.img = img;
	}

	/**
	 * Retrieves the category of the product.
	 * 
	 * @return The category of the product.
	 */
	public String getCat() {
	    return cat;
	}

	/**
	 * Sets the category of the product.
	 * 
	 * @param cat The category of the product.
	 */
	public void setCat(String cat) {
	    this.cat = cat;
	}

	/**
	 * Retrieves the rating of the product.
	 * 
	 * @return The rating of the product.
	 */
	public RatingRes getRating() {
	    return rating;
	}

	/**
	 * Sets the rating of the product.
	 * 
	 * @param rating The rating of the product.
	 */
	public void setRating(RatingRes rating) {
	    this.rating = rating;
	}   
}
