package com.example.trial.reposervices;

import com.example.trial.bos.PlaylistDetailsBo;

import java.util.List;

/**
 * The interface Playlist details service.
 */
public interface PlaylistDetailsService {
    /**
     * Gets playlist by restaurant uid.
     *
     * @param restaurantUid the restaurant uid
     * @return the playlist by restaurant uid
     */
    List<PlaylistDetailsBo> getPlaylistByOwnerUid(String restaurantUid);


    /**
     * Save play list.
     *
     * @param playlistDetailsBo the playlist details bo
     */
    PlaylistDetailsBo savePlayList(PlaylistDetailsBo playlistDetailsBo);

}
