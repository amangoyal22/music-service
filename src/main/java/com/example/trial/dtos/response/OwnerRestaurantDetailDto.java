package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerRestaurantDetailDto {
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
     * The Restaurant logo.
     */
    @JsonProperty("restaurantLogo")
    String restaurantLogo;

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
