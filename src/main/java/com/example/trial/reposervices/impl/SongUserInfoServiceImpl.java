package com.example.trial.reposervices.impl;

import com.example.trial.bos.PlaylistSongUserInfoBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.PlaylistSongUserInfoEntity;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.repository.PlaylistSongUserInfoRepository;
import com.example.trial.reposervices.SongUserInfoService;
import com.example.trial.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Song user info service.
 */
@Service
public class SongUserInfoServiceImpl implements SongUserInfoService {

    /**
     * The Playlist song user info repository.
     */
    @Autowired
    private PlaylistSongUserInfoRepository playlistSongUserInfoRepository;

    /**
     * The Entity bo mapper.
     */
    @Autowired
    private EntityBoMapper entityBoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SongUserInfoService.class);


    @Override
    public PlaylistSongUserInfoBo getNextSongDetails(final String restaurantUid) {

        final PlaylistSongUserInfoEntity playlistSongUserInfoEntity = playlistSongUserInfoRepository
                .findQueueSongByRestaurantUid(restaurantUid, CommonUtils.getDate(), MusicTrialConstant.INACTIVE);
        //updating for the playing record
        playlistSongUserInfoEntity.setPlayed(MusicTrialConstant.ACTIVE);
        playlistSongUserInfoRepository.save(playlistSongUserInfoEntity);

        return entityBoMapper.playlistSongUserInfoEntityToBo(playlistSongUserInfoEntity);
    }

    @Override
    public void doVote(String songId, boolean vote, boolean add) {
        PlaylistSongUserInfoEntity playlistSongUserInfoEntity = playlistSongUserInfoRepository
                .findBySongIdAndStatus(Long.parseLong(songId), MusicTrialConstant.ACTIVE);

        if (Objects.isNull(playlistSongUserInfoEntity)) {
            LOGGER.error("Given SongId: {} is not Active For the Voting", songId);
            throw new RuntimeException("Internal Server Error");
        }


        int upVote = playlistSongUserInfoEntity.getLikes();
        int downVote = playlistSongUserInfoEntity.getDislikes();
        if (vote) {
            if (add) {
                upVote++;
            } else {
                upVote--;
            }
            playlistSongUserInfoEntity.setLikes(upVote);
        } else {
            if (add) {
                downVote++;
            } else {
                downVote--;
            }
            playlistSongUserInfoEntity.setDislikes(downVote);
        }
        playlistSongUserInfoRepository.save(playlistSongUserInfoEntity);
    }

    @Override
    public PlaylistSongUserInfoBo save(PlaylistSongUserInfoBo playlistSongUserInfoBo) {

        PlaylistSongUserInfoEntity playlistSongUserInfoEntity = entityBoMapper
                .playlistSongUserInfoBoToEntity(playlistSongUserInfoBo);

        playlistSongUserInfoEntity = playlistSongUserInfoRepository.save(playlistSongUserInfoEntity);


        return entityBoMapper.playlistSongUserInfoEntityToBo(playlistSongUserInfoEntity);
    }

    @Override
    public void updateCurrentSongInfo(String restaurantUid, Long songId) {

        PlaylistSongUserInfoEntity playlistSongUserInfoEntity = playlistSongUserInfoRepository
                .findBySongIdAndRetaurantUidAndCreatedAtAndStatusAndPlayed(songId, restaurantUid,
                        CommonUtils.getDate(), MusicTrialConstant.ACTIVE, MusicTrialConstant.ACTIVE);

        if (Objects.isNull(playlistSongUserInfoEntity)) {
            LOGGER.error("Give SongId: {} and PlaylistId: {} doesnot Exist", songId, restaurantUid);
            throw new RuntimeException("Internal Server Error");
        }

        playlistSongUserInfoEntity.setPlayed(MusicTrialConstant.INACTIVE);
        playlistSongUserInfoEntity.setLikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
        playlistSongUserInfoEntity.setDislikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
        playlistSongUserInfoRepository.save(playlistSongUserInfoEntity);

    }

    @Override
    public List<PlaylistSongUserInfoBo> songsInCurrentQueue(String restaurantId) {

        List<PlaylistSongUserInfoEntity> playlistSongUserInfoEntities = playlistSongUserInfoRepository
                .findByRetaurantUidAndCreatedAtAndStatus(restaurantId, CommonUtils.getDate(),
                        MusicTrialConstant.ACTIVE);

        return entityBoMapper.playlistSongUserInfoEntityListToBo(playlistSongUserInfoEntities);
    }

    @Override
    public PlaylistSongUserInfoBo isPlayedForRestaurantId(String restaurantUid) {

        PlaylistSongUserInfoEntity playlistSongUserInfoEntity = playlistSongUserInfoRepository
                .findQueueSongByRestaurantUid(restaurantUid, CommonUtils.getDate(), MusicTrialConstant.ACTIVE);

        return entityBoMapper.playlistSongUserInfoEntityToBo(playlistSongUserInfoEntity);
    }

    @Override
    public boolean checkSongInQueue(String restaurantUid, Long songId) {
        final PlaylistSongUserInfoEntity playlistSongUserInfoEntity = playlistSongUserInfoRepository
                .findBySongIdAndRetaurantUidAndCreatedAtAndStatus(songId, restaurantUid, CommonUtils.getDate(),
                        MusicTrialConstant.ACTIVE);
        return Objects.isNull(playlistSongUserInfoEntity);
    }
}
