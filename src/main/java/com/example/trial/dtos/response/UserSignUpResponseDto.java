package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type User sign up response dto.
 */
public class UserSignUpResponseDto {

    /**
     * The User uid.
     */
    @JsonProperty("uid")
    String userUid;

    /**
     * The Name.
     */
    @JsonProperty("name")
    String name;

    /**
     * Gets user uid.
     *
     * @return the user uid
     */
    public String getUserUid() {
        return userUid;
    }

    /**
     * Sets user uid.
     *
     * @param userUid the user uid
     */
    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
