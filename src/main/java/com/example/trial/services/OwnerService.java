package com.example.trial.services;

import com.example.trial.bos.RestaurantBo;
import com.example.trial.dtos.response.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The interface Owner service.
 */
public interface OwnerService {

    /**
     * Login owner login response dto.
     *
     * @param uid      the uid
     * @param password the password
     * @return the owner login response dto
     */
    void login(String uid, String password);


    /**
     * Restaurant list.
     *
     * @param uid the uid
     * @return the owner restaurant list response dto
     */
    OwnerRestaurantListResponseDto restaurantList(String uid);

    /**
     * Create playlist.
     *
     * @param name     the name
     * @param ownerUid the owner uid
     */
    void createPlaylist(String name, String ownerUid);

    /**
     * Gets playlist.
     *
     * @param ownerUid the owner uid
     * @return the playlist
     */
    PlaylistResponseDto getPlaylist(String ownerUid);

    /**
     * Upload music file.
     *
     * @param multipartFile the multipart file
     * @param playlistId    the playlist id
     * @param ownerUid      the owner uid
     */
    void uploadMusicFileInPlayList(MultipartFile multipartFile, String playlistId, String ownerUid);

    /**
     * Gets playlist details.
     *
     * @param playlistId the playlist id
     * @return the playlist details
     */
    List<PlaylistSongDto> getPlaylistDescription(String playlistId);

    /**
     * Sets current queue.
     *
     * @param playlistId    the playlist id
     * @param restaurantUid the restaurant uid
     * @return the current queue
     */
    List<SongsDetailsResponseDto> setCurrentQueue(String playlistId, String restaurantUid);

    /**
     * Add song in playlist.
     *
     * @param songId     the song id
     * @param playlistId the playlist id
     */
    void addSongInPlaylist(String songId, String playlistId);

    /**
     * Stop queue.
     *
     * @param restaurantUid the restaurant uid
     */
    void stopQueue(String restaurantUid);
}
