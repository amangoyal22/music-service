package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Owner restaurant list request.
 */
public class OwnerRestaurantListRequestDto {
    /**
     * The Restaurant uid.
     */
    @NotNull
    @JsonProperty("ownerUid")
    String ownerUid;

    /**
     * Gets owner uid.
     *
     * @return the owner uid
     */
    public String getOwnerUid() {
        return ownerUid;
    }

    /**
     * Sets owner uid.
     *
     * @param ownerUid the owner uid
     */
    public void setOwnerUid(String ownerUid) {
        this.ownerUid = ownerUid;
    }
}
