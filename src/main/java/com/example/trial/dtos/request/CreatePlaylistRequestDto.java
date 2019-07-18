package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Create playlist request dto.
 */
public class CreatePlaylistRequestDto {

    /**
     * The Playlist name.
     */
    @JsonProperty("name")
    @NotNull
    String playlistName;

    /**
     * The Restaurant uid.
     */
    @JsonProperty("ownerUid")
    @NotNull
    String ownerUid;

    /**
     * Gets playlist name.
     *
     * @return the playlist name
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Sets playlist name.
     *
     * @param playlistName the playlist name
     */
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

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
}
