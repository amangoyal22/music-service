package com.example.trial.reposervices.impl;

import com.example.trial.bos.SongsDetailsBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.SongsDetailsEntity;
import com.example.trial.enums.UserType;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.models.SongsInfoModel;
import com.example.trial.repository.SongsDetailsRepository;
import com.example.trial.reposervices.SongsDetailsService;
import com.example.trial.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Songs details service.
 */
@Service
public class SongsDetailsServiceImpl implements SongsDetailsService {

    /**
     * The Songs details repository.
     */
    @Autowired
    private SongsDetailsRepository songsDetailsRepository;

    /**
     * The Entity bo mapper.
     */
    @Autowired
    private EntityBoMapper entityBoMapper;

    @Override
    public List<SongsInfoModel> getSongsDetailsForRestaurantUid(final String restaurantUid) {
        return songsDetailsRepository.fetchSongDetails(restaurantUid, CommonUtils.getDate());
    }

    @Override
    public SongsDetailsBo saveSong(final SongsDetailsBo songsDetailsBo) {
        final SongsDetailsEntity songsDetailsEntity = songsDetailsRepository
                .save(entityBoMapper.songsDetailsBoToEntity(songsDetailsBo));
        return entityBoMapper.songsDetailsEntityToBo(songsDetailsEntity);
    }

    @Override
    public List<SongsDetailsBo> getAllForPlaylistId(final Long playlistId) {
        final List<SongsDetailsEntity> songsDetailsEntities = songsDetailsRepository
                .findByPlaylistIdAndStatusAndUserType(playlistId, MusicTrialConstant.ACTIVE, UserType.OWNER.getType());
        return entityBoMapper.songsDetailsListEntityToBo(songsDetailsEntities);
    }

    @Override
    public List<SongsDetailsBo> searchSongForKey(final String searchKey) {

        final List<SongsDetailsEntity> songsDetailsEntities = songsDetailsRepository
                .findAllByStatusAndSongNameContaining(MusicTrialConstant.ACTIVE,searchKey);

        return entityBoMapper.songsDetailsListEntityToBo(songsDetailsEntities);
    }
}
