package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Vote request dto.
 */
public class VoteRequestDto {

    /**
     * The User uid.
     */
    @JsonProperty("userUid")
    String userUid;
    /**
     * The Song id.
     */
    @JsonProperty("songId")
    String songId;
    /**
     * The Up vote.
     */
    @JsonProperty("upVote")
    boolean upVote;


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
     * Is up vote boolean.
     *
     * @return the boolean
     */
    public boolean isUpVote() {
        return upVote;
    }

    /**
     * Sets up vote.
     *
     * @param upVote the up vote
     */
    public void setUpVote(boolean upVote) {
        this.upVote = upVote;
    }

    /**
     * Gets user uid.
     *
     * @return the user uid
     */
    public String getUserUid() {
        return userUid;
    }

    /**
     * Sets user uid.
     *
     * @param userUid the user uid
     */
    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }
}
