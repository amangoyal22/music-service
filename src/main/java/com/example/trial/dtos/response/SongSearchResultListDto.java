package com.example.trial.dtos.response;

import java.util.List;

/**
 * The type Song search result list dto.
 */
public class SongSearchResultListDto {

    /**
     * The Songs search details.
     */
    List<SongsSearchDetails> songsSearchDetails;


    /**
     * Gets songs search details.
     *
     * @return the songs search details
     */
    public List<SongsSearchDetails> getSongsSearchDetails() {
        return songsSearchDetails;
    }

    /**
     * Sets songs search details.
     *
     * @param songsSearchDetails the songs search details
     */
    public void setSongsSearchDetails(List<SongsSearchDetails> songsSearchDetails) {
        this.songsSearchDetails = songsSearchDetails;
    }
}
