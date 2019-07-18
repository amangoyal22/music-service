package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Add song in queue request dto.
 */
public class AddSongInQueueRequestDto {

    /**
     * The Song id.
     */
    @JsonProperty("songId")
    String songId;

    /**
     * The Playlist id.
     */
    @JsonProperty("restaurantUid")
    String restaurantUid;

    /**
     * Gets song id.
     *
     * @return the song id
     */
    public String getSongId() {
        return songId;
    }

    /**
     * Sets song id.
     *
     * @param songId the song id
     */
    public void setSongId(String songId) {
        this.songId = songId;
    }

    /**
     * Gets restaurant uid.
     *
     * @return the restaurant uid
     */
    public String getRestaurantUid() {
        return restaurantUid;
    }

    /**
     * Sets restaurant uid.
     *
     * @param restaurantUid the restaurant uid
     */
    public void setRestaurantUid(String restaurantUid) {
        this.restaurantUid = restaurantUid;
    }
}
