package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Add song request dto.
 */
public class AddSongInPlaylistRequestDto {

    /**
     * The Song id.
     */
    @JsonProperty("songId")
    String songId;

    /**
     * The Playlist id.
     */
    @JsonProperty("playlistId")
    String playlistId;

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
