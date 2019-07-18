package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Get playlist details request dto.
 */
public class GetPlaylistDetailsRequestDto {

    /**
     * The Playlist id.
     */
    @NotNull
    @JsonProperty("playlistId")
    String playlistId;

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
}
