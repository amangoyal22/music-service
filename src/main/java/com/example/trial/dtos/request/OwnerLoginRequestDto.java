package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Owner login request dto.
 */
public class OwnerLoginRequestDto {

    /**
     * The Restaurant uid.
     */
    @NotNull
    @JsonProperty("ownerUid")
    String ownerUid;

    /**
     * The Restaurant password.
     */
    @NotNull
    @JsonProperty("password")
    String ownerPassword;

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

    /**
     * Gets owner password.
     *
     * @return the owner password
     */
    public String getOwnerPassword() {
        return ownerPassword;
    }

    /**
     * Sets owner password.
     *
     * @param ownerPassword the owner password
     */
    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }
}
