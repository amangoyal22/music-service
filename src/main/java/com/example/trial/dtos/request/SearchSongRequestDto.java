package com.example.trial.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * The type Search song request dto.
 */
public class SearchSongRequestDto {

    /**
     * The Playlist id.
     */
    @NotNull
    @JsonProperty("searchKey")
    String searchKey;

    /**
     * Gets search key.
     *
     * @return the search key
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * Sets search key.
     *
     * @param searchKey the search key
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
