package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Owner restaurant list response dto.
 */
public class OwnerRestaurantListResponseDto {

    /**
     * The Owner restaurant detail dto.
     */
    @JsonProperty("list")
    List<OwnerRestaurantDetailDto> ownerRestaurantDetailDto;

    /**
     * Gets owner restaurant detail dto.
     *
     * @return the owner restaurant detail dto
     */
    public List<OwnerRestaurantDetailDto> getOwnerRestaurantDetailDto() {
        return ownerRestaurantDetailDto;
    }

    /**
     * Sets owner restaurant detail dto.
     *
     * @param ownerRestaurantDetailDto the owner restaurant detail dto
     */
    public void setOwnerRestaurantDetailDto(List<OwnerRestaurantDetailDto> ownerRestaurantDetailDto) {
        this.ownerRestaurantDetailDto = ownerRestaurantDetailDto;
    }
}
