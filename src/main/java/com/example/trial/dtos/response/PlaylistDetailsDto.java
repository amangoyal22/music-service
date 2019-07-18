package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Playlist details dto.
 */
public class PlaylistDetailsDto {

    /**
     * The Id.
     */
    @JsonProperty("id")
    private Long id;

    /**
     * The Name.
     */
    @JsonProperty("name")
    String name;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
