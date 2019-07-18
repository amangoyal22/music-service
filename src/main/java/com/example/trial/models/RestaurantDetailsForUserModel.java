package com.example.trial.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Restaurant details for user model.
 */
public class RestaurantDetailsForUserModel {
    /**
     * The Restaurant uid.
     */
    @JsonProperty("restaurantUid")
    String restaurantUid;

    /**
     * The Restaurant name.
     */
    @JsonProperty("restaurantName")
    String restaurantName;

    /**
     * The Restaurant location.
     */
    @JsonProperty("restaurantLocation")
    String restaurantLocation;

    /**
     * The Restaurant owner.
     */
    @JsonProperty("restaurantOwnerName")
    String restaurantOwner;

    /**
     * The Restaurant logo.
     */
    @JsonProperty("restaurantLogo")
    String restaurantLogo;

    /**
     * Instantiates a new Restaurant details for user model.
     *
     * @param restaurantUid      the restaurant uid
     * @param restaurantName     the restaurant name
     * @param restaurantLocation the restaurant location
     * @param restaurantOwner    the restaurant owner
     * @param restaurantLogo     the restaurant logo
     */
    public RestaurantDetailsForUserModel(String restaurantUid, String restaurantName, String restaurantLocation,
                                         String restaurantOwner, String restaurantLogo) {
        this.restaurantUid = restaurantUid;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantOwner = restaurantOwner;
        this.restaurantLogo = restaurantLogo;
    }

    /**
     * Instantiates a new Restaurant details for user model.
     */
    public RestaurantDetailsForUserModel() {
    }

    /**
     * Gets restaurant uid.
     *
     * @return the restaurant uid
     */
    public String getRestaurantUid() {
        return restaurantUid;
    }

    /**
     * Sets restaurant uid.
     *
     * @param restaurantUid the restaurant uid
     */
    public void setRestaurantUid(String restaurantUid) {
        this.restaurantUid = restaurantUid;
    }

    /**
     * Gets restaurant name.
     *
     * @return the restaurant name
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Sets restaurant name.
     *
     * @param restaurantName the restaurant name
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Gets restaurant location.
     *
     * @return the restaurant location
     */
    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    /**
     * Sets restaurant location.
     *
     * @param restaurantLocation the restaurant location
     */
    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    /**
     * Gets restaurant owner.
     *
     * @return the restaurant owner
     */
    public String getRestaurantOwner() {
        return restaurantOwner;
    }

    /**
     * Sets restaurant owner.
     *
     * @param restaurantOwner the restaurant owner
     */
    public void setRestaurantOwner(String restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }

    /**
     * Gets restaurant logo.
     *
     * @return the restaurant logo
     */
    public String getRestaurantLogo() {
        return restaurantLogo;
    }

    /**
     * Sets restaurant logo.
     *
     * @param restaurantLogo the restaurant logo
     */
    public void setRestaurantLogo(String restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

}
