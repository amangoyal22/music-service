package com.example.trial.repository;

import com.example.trial.entity.SongsDetailsEntity;
import com.example.trial.models.SongsInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Songs details repository.
 */
@Repository
public interface SongsDetailsRepository extends JpaRepository<SongsDetailsEntity, Long> {

    /**
     * Fetch song details list.
     *
     * @param restaurantUid the restaurant uid
     * @param date          the date
     * @return the list
     */
    @Query(nativeQuery = true)
    List<SongsInfoModel> fetchSongDetails(@Param("restaurantUid") String restaurantUid, @Param("tDate") String date);

    /**
     * Find by playlist id and status list.
     *
     * @param playlistId the playlist id
     * @param status     the status
     * @param userType   the user type
     * @return the list
     */
    @Query(value = "SELECT sg.*  from songs_details sg,song_playlist_details spd where spd.playlist_id =:playlistId "
            + "and spd.song_id = sg.id and sg.status =:status and spd.status =:status and sg.user_type =:userType ",
            nativeQuery = true)
    List<SongsDetailsEntity> findByPlaylistIdAndStatusAndUserType(@Param("playlistId") Long playlistId,
                                                                  @Param("status") byte status,
                                                                  @Param("userType") byte userType);


    /**
     * Find all by status and song name is like list.
     *
     * @param status the status
     * @param key    the key
     * @return the list
     */
    List<SongsDetailsEntity> findAllByStatusAndSongNameContaining(byte status, String key);
}
