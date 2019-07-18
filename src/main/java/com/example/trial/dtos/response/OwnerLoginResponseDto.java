package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Owner login response dto.
 */
public class OwnerLoginResponseDto {

    /**
     * The Restaurant uid.
     */
    @JsonProperty("uid")
    String restaurantUid;

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
    
}
