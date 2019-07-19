package com.example.trial.services.impl;

import com.example.trial.bos.PlaylistSongUserInfoBo;
import com.example.trial.bos.SongsDetailsBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.dtos.response.GetNextSongDetailsResponseDto;
import com.example.trial.dtos.response.SongSearchResultListDto;
import com.example.trial.dtos.response.SongsDetailsResponseDto;
import com.example.trial.enums.UserType;
import com.example.trial.mapper.BoToDtoMapper;
import com.example.trial.models.SongsInfoModel;
import com.example.trial.reposervices.SongUserInfoService;
import com.example.trial.reposervices.SongsDetailsService;
import com.example.trial.services.*;
import com.example.trial.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * The type Common service.
 */
@Service
public class CommonServiceImpl implements CommonService {

    /**
     * The Songs details service.
     */
    @Autowired
    private SongsDetailsService songsDetailsService;

    /**
     * The Song user info service.
     */
    @Autowired
    private SongUserInfoService songUserInfoService;

    /**
     * The Bo to dto mapper.
     */
    @Autowired
    private BoToDtoMapper boToDtoMapper;


    /**
     * The Redis service.
     */
    @Autowired
    private RedisService redisService;

    /**
     * The File storage service.
     */
    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<SongsDetailsResponseDto> queueDetails(String restaurantUid) {
        List<SongsInfoModel> songsInfoModels = songsDetailsService.getSongsDetailsForRestaurantUid(restaurantUid);
        return boToDtoMapper.getSongsDetailsDto(songsInfoModels);
    }

    @Override
    public GetNextSongDetailsResponseDto updateAndNextSongRecord(String restaurantUid) {
        //restauarant id --> is played
        //yes --> id ,other and is played
        // no --> list play first one
        PlaylistSongUserInfoBo playlistSongUserInfoBo1 = songUserInfoService.isPlayedForRestaurantId(restaurantUid);

        if (Objects.nonNull(playlistSongUserInfoBo1)) {
            songUserInfoService.updateCurrentSongInfo(restaurantUid, playlistSongUserInfoBo1.getSongId());
            redisService.deleteSongKeys(playlistSongUserInfoBo1.getSongId(),restaurantUid);
        }



        final PlaylistSongUserInfoBo playlistSongUserInfoBo = songUserInfoService.getNextSongDetails(restaurantUid);

        return boToDtoMapper.getNextSongDto(playlistSongUserInfoBo.getSongId());

    }

    @Override
    @Transactional
    public void uploadMusicFileInQueue(MultipartFile multipartFile, String restaurantUid, String adderUid) {

        SongsDetailsBo songsDetailsBo = new SongsDetailsBo();

        //file info
        final String location = fileStorageService.storeFile(multipartFile);
        songsDetailsBo = CommonUtils.getSongsInfo(location, songsDetailsBo);
        songsDetailsBo.setSongLocation(location);
        songsDetailsBo.setSongFormat(multipartFile.getContentType());
        //user info
        songsDetailsBo.setStatus(MusicTrialConstant.ACTIVE);
        songsDetailsBo.setAdderUid(adderUid);
        songsDetailsBo.setUserType(UserType.COMMON.getType());
        songsDetailsBo = songsDetailsService.saveSong(songsDetailsBo);

        //Add in queue
        PlaylistSongUserInfoBo playlistSongUserInfoBo = new PlaylistSongUserInfoBo();
        playlistSongUserInfoBo.setRetaurantUid(restaurantUid);
        playlistSongUserInfoBo.setSongId(songsDetailsBo.getId());
        playlistSongUserInfoBo.setCreatedAt(CommonUtils.getDate());
        playlistSongUserInfoBo.setLikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
        playlistSongUserInfoBo.setDislikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
        playlistSongUserInfoBo.setPlayed(MusicTrialConstant.INACTIVE);
        playlistSongUserInfoBo.setStatus(MusicTrialConstant.ACTIVE);
        songUserInfoService.save(playlistSongUserInfoBo);
    }


    @Override
    public SongSearchResultListDto searchSong(String search) {

        return boToDtoMapper.getSongsDetailsDtoForSearch(songsDetailsService.searchSongForKey(search));
    }

    @Override
    public void addSongInQueue(String songId, String restaurantUid) {
        if (songUserInfoService.checkSongInQueue(restaurantUid, Long.valueOf(songId))) {

            PlaylistSongUserInfoBo playlistSongUserInfoBo = new PlaylistSongUserInfoBo();
            playlistSongUserInfoBo.setRetaurantUid(restaurantUid);
            playlistSongUserInfoBo.setSongId(Long.valueOf(songId));
            playlistSongUserInfoBo.setCreatedAt(CommonUtils.getDate());
            playlistSongUserInfoBo.setLikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
            playlistSongUserInfoBo.setDislikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
            playlistSongUserInfoBo.setPlayed(MusicTrialConstant.INACTIVE);
            playlistSongUserInfoBo.setStatus(MusicTrialConstant.ACTIVE);
            songUserInfoService.save(playlistSongUserInfoBo);

        } else {
            throw new RuntimeException("Song Already In Queue");
        }
    }
}
