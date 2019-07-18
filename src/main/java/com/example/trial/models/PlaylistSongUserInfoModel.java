package com.example.trial.models;


import javax.persistence.*;
import java.util.Date;

/**
 * The type Playlist song user info model.
 */
@MappedSuperclass
public class PlaylistSongUserInfoModel {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    /**
     * The Retaurant uid.
     */
    @Column(name = "restaurant_uid")
    String retaurantUid;

    /**
     * The Song id.
     */
    @Column(name = "song_id")
    Long songId;


    /**
     * The Likes.
     */
    @Column(name = "likes")
    int likes;


    /**
     * The Dislikes.
     */
    @Column(name = "dislikes")
    int dislikes;

    /**
     * The Status.
     */
    @Column(name = "status")
    byte status;

    /**
     * The Played.
     */
    @Column(name = "is_played")
    byte played;

    /**
     * The Created at.
     */
    @Column(name = "created_at")
    String createdAt;

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
     * Gets retaurant uid.
     *
     * @return the retaurant uid
     */
    public String getRetaurantUid() {
        return retaurantUid;
    }

    /**
     * Sets retaurant uid.
     *
     * @param retaurantUid the retaurant uid
     */
    public void setRetaurantUid(String retaurantUid) {
        this.retaurantUid = retaurantUid;
    }

    /**
     * Gets song id.
     *
     * @return the song id
     */
    public Long getSongId() {
        return songId;
    }

    /**
     * Sets song id.
     *
     * @param songId the song id
     */
    public void setSongId(Long songId) {
        this.songId = songId;
    }

    /**
     * Gets likes.
     *
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Sets likes.
     *
     * @param likes the likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Gets dislikes.
     *
     * @return the dislikes
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * Sets dislikes.
     *
     * @param dislikes the dislikes
     */
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * Gets played.
     *
     * @return the played
     */
    public byte getPlayed() {
        return played;
    }

    /**
     * Sets played.
     *
     * @param played the played
     */
    public void setPlayed(byte played) {
        this.played = played;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
