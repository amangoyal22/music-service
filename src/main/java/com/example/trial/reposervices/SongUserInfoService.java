package com.example.trial.reposervices;

import com.example.trial.bos.PlaylistSongUserInfoBo;
import com.example.trial.entity.PlaylistSongUserInfoEntity;

import java.util.List;

/**
 * The interface Song user info service.
 */
public interface SongUserInfoService {
    /**
     * Gets current song details.
     *
     * @param restaurantUid the restaurant uid
     * @return the current song details
     */
    PlaylistSongUserInfoBo getNextSongDetails(String restaurantUid);

    /**
     * Gets vote.
     *
     * @param songId the song id
     * @param vote   the vote
     * @param add    the add
     * @return the vote
     */
    void doVote(String songId, boolean vote, boolean add);

    /**
     * Save playlist song user info bo.
     *
     * @param playlistSongUserInfoBo the playlist song user info bo
     * @return the playlist song user info bo
     */
    PlaylistSongUserInfoBo save(PlaylistSongUserInfoBo playlistSongUserInfoBo);

    /**
     * Update current song info.
     *
     * @param restaurantUid the restaurant uid
     * @param songId        the song id
     */
    void updateCurrentSongInfo(String restaurantUid,Long songId);

    /**
     * Songs in current queue list.
     *
     * @param restaurantUid the restaurant uid
     * @return the list
     */
    List<PlaylistSongUserInfoBo> songsInCurrentQueue(String restaurantUid);

    /**
     * Is played for restaurant id playlist song user info bo.
     *
     * @param restaurantUid the restaurant uid
     * @return the playlist song user info bo
     */
    PlaylistSongUserInfoBo isPlayedForRestaurantId(String restaurantUid);

    /**
     * Update current song info.
     *
     * @param restaurantUid the restaurant uid
     * @param songId        the song id
     */
    boolean checkSongInQueue(String restaurantUid,Long songId);

}
