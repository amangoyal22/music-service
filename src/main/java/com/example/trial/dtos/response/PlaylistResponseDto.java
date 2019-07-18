package com.example.trial.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Playlist response dto.
 */
public class PlaylistResponseDto {

    /**
     * The Playlist.
     */
    @JsonProperty("playlistList")
    List<PlaylistDetailsDto> playlist;

    /**
     * Gets playlist.
     *
     * @return the playlist
     */
    public List<PlaylistDetailsDto> getPlaylist() {
        return playlist;
    }

    /**
     * Sets playlist.
     *
     * @param playlist the playlist
     */
    public void setPlaylist(List<PlaylistDetailsDto> playlist) {
        this.playlist = playlist;
    }
}
