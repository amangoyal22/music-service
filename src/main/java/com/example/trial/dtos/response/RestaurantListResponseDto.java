package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Restaurant list response dto.
 */
public class RestaurantListResponseDto {

    /**
     * The Restaurant details.
     */
    @JsonProperty("RestaurantDetails")
    List<RestaurantDetailsDto> restaurantDetails;

    /**
     * Gets restaurant details.
     *
     * @return the restaurant details
     */
    public List<RestaurantDetailsDto> getRestaurantDetails() {
        return restaurantDetails;
    }

    /**
     * Sets restaurant details.
     *
     * @param restaurantDetails the restaurant details
     */
    public void setRestaurantDetails(List<RestaurantDetailsDto> restaurantDetails) {
        this.restaurantDetails = restaurantDetails;
    }
}
