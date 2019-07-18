package com.example.trial.repository;

import com.example.trial.entity.SongPlaylistDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Song playlist details repositry.
 */
@Repository
public interface SongPlaylistDetailsRepositry extends JpaRepository<SongPlaylistDetailsEntity, Long> {

    /**
     * Find all by playlist id and status list.
     *
     * @param playlistId the playlist id
     * @param status     the status
     * @return the list
     */
    List<SongPlaylistDetailsEntity> findAllByPlaylistIdAndStatus(Long playlistId, byte status);

    /**
     * Find by song id and playlist id and status song playlist details entity.
     *
     * @param songId     the song id
     * @param playlistId the playlist id
     * @param status     the status
     * @return the song playlist details entity
     */
    SongPlaylistDetailsEntity findBySongIdAndPlaylistIdAndStatus(Long songId,Long playlistId, byte status);

}
