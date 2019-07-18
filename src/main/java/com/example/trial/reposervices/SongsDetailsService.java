package com.example.trial.reposervices;

import com.example.trial.bos.SongsDetailsBo;
import com.example.trial.models.SongsInfoModel;

import java.util.List;

/**
 * The interface Songs details service.
 */
public interface SongsDetailsService {
    /**
     * Gets songs details for playlist id.
     *
     * @param restaurantUid the restaurant uid
     * @return the songs details
     */
    List<SongsInfoModel> getSongsDetailsForRestaurantUid(String restaurantUid);

    /**
     * Save song songs details bo.
     *
     * @param songsDetailsBo the songs details bo
     * @return the songs details bo
     */
    SongsDetailsBo saveSong(SongsDetailsBo songsDetailsBo);

    /**
     * Gets all for playlist id.
     *
     * @param playlistId the playlist id
     * @return the all for playlist id
     */
    List<SongsDetailsBo> getAllForPlaylistId(Long playlistId);


    /**
     * Search song for key list.
     *
     * @param searchKey the search key
     * @return the list
     */
    List<SongsDetailsBo> searchSongForKey(String searchKey);
}
