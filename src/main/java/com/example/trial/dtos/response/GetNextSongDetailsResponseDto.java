package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Get current song details response dto.
 */
public class GetNextSongDetailsResponseDto {

    /**
     * The Song id.
     */
    @JsonProperty("songId")
    Long songId;

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
}
