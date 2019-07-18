package com.example.trial.reposervices.impl;

import com.example.trial.bos.PlaylistDetailsBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.PlaylistDetailsEntity;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.repository.PlaylistDetailsRepository;
import com.example.trial.reposervices.PlaylistDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Playlist details service.
 */
@Service
public class PlaylistDetailsServiceImpl implements PlaylistDetailsService {

    /**
     * The Entity bo mapper.
     */
    @Autowired
    private EntityBoMapper entityBoMapper;

    /**
     * The Restaurants playlist details repository.
     */
    @Autowired
    private PlaylistDetailsRepository playlistDetailsRepository;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistDetailsService.class);


    @Override
    public List<PlaylistDetailsBo> getPlaylistByOwnerUid(String ownerUid) {

        List<PlaylistDetailsEntity> restaurantsPlaylistDetailsEntities = playlistDetailsRepository
                .findByOwnerUidAndStatus(ownerUid, MusicTrialConstant.ACTIVE);

        return entityBoMapper.restaurantsPlaylistDetailsListEntityToBo(restaurantsPlaylistDetailsEntities);
    }

    @Override
    public PlaylistDetailsBo savePlayList(PlaylistDetailsBo playlistDetailsBo) {
        PlaylistDetailsEntity playlistDetailsEntity = entityBoMapper
                .restaurantsPlaylistDetailsBoToEntity(playlistDetailsBo);
        playlistDetailsEntity = playlistDetailsRepository.save(playlistDetailsEntity);
        return entityBoMapper.restaurantsPlaylistDetailsEntityToBo(playlistDetailsEntity);

    }

}
