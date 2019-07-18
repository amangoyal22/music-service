package com.example.trial.models;

import javax.persistence.*;

/**
 * The type Song playlist details.
 */
@MappedSuperclass
public class SongPlaylistDetailsModel {
    /**
     * The Id.
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Song id.
     */
    @Column(name = "song_id")
    private Long songId;

    /**
     * The Playlist id.
     */
    @Column(name = "playlist_id")
    private Long playlistId;

    /**
     * The Status.
     */
    @Column(name = "status")
    private byte status;


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
     * Gets playlist id.
     *
     * @return the playlist id
     */
    public Long getPlaylistId() {
        return playlistId;
    }

    /**
     * Sets playlist id.
     *
     * @param playlistId the playlist id
     */
    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
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
}
