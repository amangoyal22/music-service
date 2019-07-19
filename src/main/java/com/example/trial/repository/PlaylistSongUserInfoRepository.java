package com.example.trial.repository;

import com.example.trial.entity.PlaylistSongUserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Playlist song user info repository.
 */
@Repository
public interface PlaylistSongUserInfoRepository extends JpaRepository<PlaylistSongUserInfoEntity, Long> {

    /**
     * Find by song id playlist song user info entity.
     *
     * @param restaurantUid the restaurant uid
     * @param date          the date
     * @param isPlayed      the is played
     * @return the playlist song user info entity
     */
    @Query(value = "SELECT u.* FROM playlist_song_user_info u WHERE u.status = 1 and u.restaurant_uid = :restaurantUid "
            + "and" + " u.created_at = :tdate and u.is_played =:isPlayed ORDER by (u.likes-u.dislikes) DESC, u.id ASC Limit 1",
            nativeQuery = true)
    PlaylistSongUserInfoEntity findQueueSongByRestaurantUid(@Param("restaurantUid") String restaurantUid,
                                                            @Param("tdate") String date,
                                                            @Param("isPlayed") byte isPlayed);

    /**
     * Find by song id playlist song user info entity.
     *
     * @param restaurantUid the restaurant uid
     * @param songId        the song id
     * @param status        the status
     * @return the playlist song user info entity
     */
    PlaylistSongUserInfoEntity findByRetaurantUidAndSongIdAndStatus(String restaurantUid, Long songId, byte status);

    /**
     * Find by song id and playlist id and created at and status playlist song user info entity.
     *
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     * @param createdAt     the created at
     * @param status        the status
     * @param played        the played
     * @return the playlist song user info entity
     */
    PlaylistSongUserInfoEntity findBySongIdAndRetaurantUidAndCreatedAtAndStatusAndPlayed(Long songId,
                                                                                         String restaurantUid,
                                                                                         String createdAt, byte status,
                                                                                         byte played);

    /**
     * Find by retaurant uid list.
     *
     * @param retaurantUid the retaurant uid
     * @param createdAt    the created at
     * @param status       the status
     * @return the list
     */
    List<PlaylistSongUserInfoEntity> findByRetaurantUidAndCreatedAtAndStatus(String retaurantUid, String createdAt, byte status);


    /**
     * Find by song id and retaurant uid and created at and status playlist song user info entity.
     *
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     * @param createdAt     the created at
     * @param status        the status
     * @return the playlist song user info entity
     */
    PlaylistSongUserInfoEntity findBySongIdAndRetaurantUidAndCreatedAtAndStatus(Long songId, String restaurantUid,
                                                                                String createdAt, byte status);

    /**
     * Find by retaurant uid and and created at and status list.
     *
     * @param restaurantUid the restaurant uid
     * @param createdAt     the created at
     * @param status        the status
     * @return the list
     */
    List<PlaylistSongUserInfoEntity> findByRetaurantUidAndAndCreatedAtAndStatus(String restaurantUid, String createdAt,
                                                                                byte status);

    @Query(value = "SELECT u.* FROM playlist_song_user_info u WHERE u.status = 1 and u.restaurant_uid = :restaurantUid and u.song_id !=:songId "
            + "and" + " u.created_at = :tdate and u.is_played =:isPlayed ORDER by (u.likes-u.dislikes) DESC, u.id ASC Limit 1",
            nativeQuery = true)
    PlaylistSongUserInfoEntity findQueueSongByRestaurantUidAndSongId(@Param("restaurantUid") String restaurantUid,
                                                                     @Param("tdate") String date,
                                                                     @Param("isPlayed") byte isPlayed,
                                                                     @Param("songId") Long songId);
}
