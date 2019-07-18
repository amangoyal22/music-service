package com.example.trial.models;

import javax.persistence.*;

/**
 * The type Songs details model.
 */
@MappedSuperclass
public class SongsDetailsModel {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * The Song name.
     */
    @Column(name = "song_name")
    String songName;
    /**
     * The Song genre.
     */
    @Column(name = "song_genre")
    String songGenre;
    /**
     * The Song location.
     */
    @Column(name = "song_location")
    String songLocation;
    /**
     * The Song length.
     */
    @Column(name = "song_length")
    Integer songLength;
    /**
     * The Song format.
     */
    @Column(name = "song_format")
    String songFormat;
    /**
     * The User type.
     */
    @Column(name = "user_type")
    byte userType;

    /**
     * The Adder uid.
     */
    @Column(name = "adder_uid")
    String adderUid;

    /**
     * The Status.
     */
    @Column(name = "status")
    byte status;

    /**
     * The Is authorize.
     */
    @Column(name = "authorize")
    byte authorize;

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
     * Gets song name.
     *
     * @return the song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Sets song name.
     *
     * @param songName the song name
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * Gets song genre.
     *
     * @return the song genre
     */
    public String getSongGenre() {
        return songGenre;
    }

    /**
     * Sets song genre.
     *
     * @param songGenre the song genre
     */
    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    /**
     * Gets song location.
     *
     * @return the song location
     */
    public String getSongLocation() {
        return songLocation;
    }

    /**
     * Sets song location.
     *
     * @param songLocation the song location
     */
    public void setSongLocation(String songLocation) {
        this.songLocation = songLocation;
    }

    /**
     * Gets song length.
     *
     * @return the song length
     */
    public Integer getSongLength() {
        return songLength;
    }

    /**
     * Sets song length.
     *
     * @param songLength the song length
     */
    public void setSongLength(Integer songLength) {
        this.songLength = songLength;
    }

    /**
     * Gets song format.
     *
     * @return the song format
     */
    public String getSongFormat() {
        return songFormat;
    }

    /**
     * Sets song format.
     *
     * @param songFormat the song format
     */
    public void setSongFormat(String songFormat) {
        this.songFormat = songFormat;
    }

    /**
     * Gets user type.
     *
     * @return the user type
     */
    public byte getUserType() {
        return userType;
    }

    /**
     * Sets user type.
     *
     * @param userType the user type
     */
    public void setUserType(byte userType) {
        this.userType = userType;
    }

    /**
     * Gets adder uid.
     *
     * @return the adder uid
     */
    public String getAdderUid() {
        return adderUid;
    }

    /**
     * Sets adder uid.
     *
     * @param adderUid the adder uid
     */
    public void setAdderUid(String adderUid) {
        this.adderUid = adderUid;
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
     * Gets is authorize.
     *
     * @return the is authorize
     */
    public byte getAuthorize() {
        return authorize;
    }

    /**
     * Sets is authorize.
     *
     * @param authorize the is authorize
     */
    public void setAuthorize(byte authorize) {
        this.authorize = authorize;
    }

}
