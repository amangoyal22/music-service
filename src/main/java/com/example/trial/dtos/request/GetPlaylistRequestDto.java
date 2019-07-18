package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Get playlist request dto.
 */
public class GetPlaylistRequestDto {

    /**
     * The Restaurant uid.
     */
    @JsonProperty("ownerUid")
    @NotNull
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
