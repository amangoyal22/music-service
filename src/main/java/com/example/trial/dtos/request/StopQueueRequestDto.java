package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Stop queue request dto.
 */
public class StopQueueRequestDto {

    /**
     * The Restaurant uid.
     */
    @NotNull
    @JsonProperty("restaurantUid")
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
