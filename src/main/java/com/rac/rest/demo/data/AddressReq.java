package com.rac.rest.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Address Request Details.
 */
public class AddressReq {

    /** Address Line 1. */
    @JsonProperty("adrLine1")
    private String adrLine1;

    /** Address Line 2. */
    @JsonProperty("adrLine2")
    private String adrLine2;

    /** Postal Code. */
    @JsonProperty("postcode")
    private String postcode;

    /** State. */
    @JsonProperty("state")
    private String state;

    /** Country. */
    @JsonProperty("country")
    private String country;

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
