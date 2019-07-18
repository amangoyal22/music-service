package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

/**
 * The type User sign in request dto.
 */
public class UserSignInRequestDto {

    /**
     * The User uid.
     */
    @JsonProperty("email")
    @NotNull
    String email;

    /**
     * The User password.
     */
    @NotNull
    @JsonProperty("password")
    String password;

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
