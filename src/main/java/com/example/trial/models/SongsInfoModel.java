package com.example.trial.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.MappedSuperclass;

/**
 * The type Songs info model.
 */
@MappedSuperclass
public class SongsInfoModel {

    /**
     * The Likes.
     */
    @JsonProperty("likes")
    private Integer likes;
    /**
     * The Dislikes.
     */
    @JsonProperty("dislikes")
    private Integer dislikes;
    /**
     * The Genre.
     */
    @JsonProperty("genre")
    private String genre;
    /**
     * The Length.
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * The Name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The Id.
     */
    @JsonProperty("id")
    private Long id;

    /**
     * The Is current.
     */
    @JsonProperty("current")
    byte isCurrent;

    /**
     * The Location.
     */
    @JsonProperty("location")
    String location;

    /**
     * Instantiates a new Songs info model.
     *
     * @param likes     the likes
     * @param dislikes  the dislikes
     * @param genre     the genre
     * @param length    the length
     * @param name      the name
     * @param id        the id
     * @param isCurrent the is current
     * @param location  the location
     */
    public SongsInfoModel(Integer likes, Integer dislikes, String genre, Integer length, String name, Long id, byte isCurrent, String location) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.genre = genre;
        this.length = length;
        this.name = name;
        this.id = id;
        this.isCurrent = isCurrent;
        this.location = location;
    }

    /**
     * Instantiates a new Songs info model.
     */
    public SongsInfoModel() {
    }

    /**
     * Gets likes.
     *
     * @return the likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * Sets likes.
     *
     * @param likes the likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * Gets dislikes.
     *
     * @return the dislikes
     */
    public Integer getDislikes() {
        return dislikes;
    }

    /**
     * Sets dislikes.
     *
     * @param dislikes the dislikes
     */
    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
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
     * Gets is current.
     *
     * @return the is current
     */
    public byte getIsCurrent() {
        return isCurrent;
    }

    /**
     * Sets is current.
     *
     * @param is_current the is current
     */
    public void setIsCurrent(byte is_current) {
        this.isCurrent = is_current;
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
}
