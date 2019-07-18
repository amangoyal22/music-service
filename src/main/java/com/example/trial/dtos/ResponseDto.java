package com.example.trial.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Response dto.
 */
public class ResponseDto {

    /**
     * The Status.
     */
    @JsonProperty("status")
    String status;

    /**
     * The Message.
     */
    @JsonProperty("message")
    String message;

    /**
     * The Object.
     */
    @JsonProperty("data")
    Object object;

    /**
     * Instantiates a new Response dto.
     *
     * @param status  the status
     * @param message the message
     * @param object  the object
     */
    public ResponseDto(String status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets object.
     *
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets object.
     *
     * @param object the object
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
