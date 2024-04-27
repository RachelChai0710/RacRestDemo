package com.rac.rest.demo.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * Product Entity Class.
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7889036971180331298L;

	/**
	 * Product ID. 
	 * Primary Key
	 */
	@Id
	@Column(name = "PRD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prdId; 
	
	/**
	 * Product's Title. 
	 * Non-nullable field.
	 */
	@Column(nullable=false)
	private String title;
	
	/**
	 * Product's Price. 
	 */
	private double price;
	
	/**
	 * Product's Description. 
	 */
	@Lob 
	@Column(name = "DESCRIPTION", length=512)
	private String desc;
	
	/**
	 * Product's Category. 
	 */
	@Column(name = "CATEGORY")
	private String cat;
	
	/**
	 * Product's Image. 
	 */
	@Column(name = "IMAGE")
	private String img;
	
	/**
	 * Product's Rate. 
	 */
	private double rate;
	
	/**
	 * Product's Count. 
	 */
	private int count;
	
	/**
     * Default constructor.
     */
    public Product() {

    }

    /**
     * Constructs a new Product object with the specified attributes.
     *
     * @param title the title of the product
     * @param price the price of the product
     * @param desc the description of the product
     * @param cat the category of the product
     * @param img the image URL of the product
     * @param rate the rating of the product
     * @param count the count of the product
     */
    public Product(String title, double price, String desc, String cat, String img, double rate,
            int count) {
        super();
        this.title = title;
        this.price = price;
        this.desc = desc;
        this.cat = cat;
        this.img = img;
        this.rate = rate;
        this.count = count;
    }
	
	/**
	 * Retrieves the unique identifier of the product.
	 *
	 * @return the product ID
	 */
	public long getPrdId() {
	    return prdId;
	}
	
	/**
	 * Sets the unique identifier of the product.
	 *
	 * @param prdId the product ID to set
	 */
	public void setPrdId(long prdId) {
	    this.prdId = prdId;
	}
	
	/**
	 * Retrieves the title of the product.
	 *
	 * @return the title of the product
	 */
	public String getTitle() {
	    return title;
	}
	
	/**
	 * Sets the title of the product.
	 *
	 * @param title the title of the product to set
	 */
	public void setTitle(String title) {
	    this.title = title;
	}
	
	/**
	 * Retrieves the price of the product.
	 *
	 * @return the price of the product
	 */
	public double getPrice() {
	    return price;
	}
	
	/**
	 * Sets the price of the product.
	 *
	 * @param price the price of the product to set
	 */
	public void setPrice(double price) {
	    this.price = price;
	}
	
	/**
	 * Retrieves the description of the product.
	 *
	 * @return the description of the product
	 */
	public String getDesc() {
	    return desc;
	}
	
	/**
	 * Sets the description of the product.
	 *
	 * @param desc the description of the product to set
	 */
	public void setDesc(String desc) {
	    this.desc = desc;
	}
	
	/**
	 * Retrieves the category of the product.
	 *
	 * @return the category of the product
	 */
	public String getCat() {
	    return cat;
	}
	
	/**
	 * Sets the category of the product.
	 *
	 * @param cat the category of the product to set
	 */
	public void setCat(String cat) {
	    this.cat = cat;
	}
	
	/**
	 * Retrieves the image URL of the product.
	 *
	 * @return the image URL of the product
	 */
	public String getImg() {
	    return img;
	}
	
	/**
	 * Sets the image URL of the product.
	 *
	 * @param img the image URL of the product to set
	 */
	public void setImg(String img) {
	    this.img = img;
	}
	
	/**
	 * Retrieves the rating of the product.
	 *
	 * @return the rating of the product
	 */
	public double getRate() {
	    return rate;
	}
	
	/**
	 * Sets the rating of the product.
	 *
	 * @param rate the rating of the product to set
	 */
	public void setRate(double rate) {
	    this.rate = rate;
	}
	
	/**
	 * Retrieves the count of the product.
	 *
	 * @return the count of the product
	 */
	public int getCount() {
	    return count;
	}
	
	/**
	 * Sets the count of the product.
	 *
	 * @param count the count of the product to set
	 */
	public void setCount(int count) {
	    this.count = count;
	}
}
