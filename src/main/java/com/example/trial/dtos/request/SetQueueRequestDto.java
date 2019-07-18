package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class SetQueueRequestDto {

    /**
     * The Playlist id.
     */
    @NotNull
    @JsonProperty("playlistId")
    String playlistId;

    /**
     * The Restaurant uid.
     */
    @NotNull
    @JsonProperty("restaurantUid")
    String restaurantUid;

    /**
     * Gets playlist id.
     *
     * @return the playlist id
     */
    public String getPlaylistId() {
        return playlistId;
    }

    /**
     * Sets playlist id.
     *
     * @param playlistId the playlist id
     */
    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
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
