package com.example.trial.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The type Restaurants playlist details model.
 */
@MappedSuperclass
public class PlaylistDetailsModel {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * The Playlist name.
     */
    @NotNull
    @Column(name = "playlist_name")
    String playlistName;

    /**
     * The Restaurant uid.
     */
    @NotNull
    @Column(name = "owner_uid")
    String ownerUid;

    /**
     * The Status.
     */
    @Column(name = "status")
    byte status;

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
