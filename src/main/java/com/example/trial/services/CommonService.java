package com.example.trial.services;

import com.example.trial.dtos.response.GetNextSongDetailsResponseDto;
import com.example.trial.dtos.response.SongSearchResultListDto;
import com.example.trial.dtos.response.SongsDetailsResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The interface Common service.
 */
public interface CommonService {

    /**
     * Playlist details list.
     *
     * @param restaurantUid the restaurant uid
     * @return the list
     */
    List<SongsDetailsResponseDto> queueDetails(String restaurantUid);


    /**
     * Update and next song record get next song details response dto.
     *
     * @param restaurantUid the restaurant uid
     * @return the get next song details response dto
     */
    GetNextSongDetailsResponseDto updateAndNextSongRecord(String restaurantUid);


    /**
     * Upload music file.
     *
     * @param multipartFile the multipart file
     * @param restaurantUid the restaurant uid
     * @param adderUid      the adder uid
     */
    void uploadMusicFileInQueue(MultipartFile multipartFile, String restaurantUid, String adderUid);

    /**
     * Search song list.
     *
     * @param search the search
     * @return the list
     */
    SongSearchResultListDto searchSong(String search);


    /**
     * Add song in queue.
     *
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     */
    void addSongInQueue(String songId, String restaurantUid);



}
