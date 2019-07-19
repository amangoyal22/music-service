package com.example.trial.reposervices.impl;

import com.example.trial.bos.SongPlaylistDetailsBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.SongPlaylistDetailsEntity;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.reposervices.SongPlaylistDetailsService;
import com.example.trial.repository.SongPlaylistDetailsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Playlist song details service.
 */
@Service
public class SongPlaylistDetailsServiceImpl implements SongPlaylistDetailsService {

    /**
     * The Song playlist details repositry.
     */
    @Autowired
    private SongPlaylistDetailsRepositry songPlaylistDetailsRepositry;

    /**
     * The Entity bo mapper.
     */
    @Autowired
    private EntityBoMapper entityBoMapper;

    @Override
    public SongPlaylistDetailsBo savePlaylistSong(SongPlaylistDetailsBo songPlaylistDetailsBo) {
        SongPlaylistDetailsEntity songPlaylistDetailsEntity = entityBoMapper
                .songPlaylistDetailsBoToEntity(songPlaylistDetailsBo);
        songPlaylistDetailsEntity.setStatus(MusicTrialConstant.ACTIVE);
        songPlaylistDetailsEntity = songPlaylistDetailsRepositry.save(songPlaylistDetailsEntity);
        return entityBoMapper.songPlaylistDetailsEntityToBo(songPlaylistDetailsEntity);
    }

    @Override
    public List<SongPlaylistDetailsBo> getSongsForPlaylist(Long playlistId) {
        List<SongPlaylistDetailsEntity> songPlaylistDetailsEntities = songPlaylistDetailsRepositry
                .findAllByPlaylistIdAndStatus(playlistId, MusicTrialConstant.ACTIVE);
        return entityBoMapper.songPlaylistDetailsEntityListToBo(songPlaylistDetailsEntities);
    }

    @Override
    public boolean checkSongIdAndPlaylistId(String songId, String playlistId) {
        SongPlaylistDetailsEntity songPlaylistDetailsEntity = songPlaylistDetailsRepositry
                .findBySongIdAndPlaylistIdAndStatus(Long.valueOf(songId), Long.valueOf(playlistId),
                        MusicTrialConstant.ACTIVE);
        return Objects.isNull(songPlaylistDetailsEntity);
    }
}
