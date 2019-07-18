package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Songs search details.
 */
public class SongsSearchDetails {

    /**
     * The Song id.
     */
    @JsonProperty("id")
    Long id;
    /**
     * The Name.
     */
    @JsonProperty("name")
    String name;
    /**
     * The Genre.
     */
    @JsonProperty("genre")
    String genre;
    /**
     * The Location.
     */
    @JsonProperty("location")
    String location;
    /**
     * The Length.
     */
    @JsonProperty("length")
    Integer length;

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

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(Integer length) {
        this.length = length;
    }
}
