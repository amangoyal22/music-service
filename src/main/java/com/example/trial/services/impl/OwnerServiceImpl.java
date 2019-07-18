package com.example.trial.services.impl;

import com.example.trial.bos.*;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.dtos.response.*;
import com.example.trial.enums.UserType;
import com.example.trial.mapper.BoToDtoMapper;
import com.example.trial.models.SongsInfoModel;
import com.example.trial.reposervices.*;
import com.example.trial.services.*;
import com.example.trial.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Owner service.
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    /**
     * The Owner repo service.
     */
    @Autowired
    OwnerRepoService ownerRepoService;


    /**
     * The Restaurants repo service.
     */
    @Autowired
    RestaurantsRepoService restaurantsRepoService;

    /**
     * The Playlist details service.
     */
    @Autowired
    private PlaylistDetailsService playlistDetailsService;

    /**
     * The Songs details service.
     */
    @Autowired
    private SongsDetailsService songsDetailsService;

    /**
     * The File storage service.
     */
    @Autowired
    private FileStorageService fileStorageService;

    /**
     * The Song user info service.
     */
    @Autowired
    private SongUserInfoService songUserInfoService;


    @Autowired
    SongPlaylistDetailsService songPlaylistDetailsService;

    /**
     * The Bo to dto mapperl.
     */
    @Autowired
    private BoToDtoMapper boToDtoMapper;


    @Override
    public void login(String uid,String password) {

        ownerRepoService.getDetailsByUidAndPassword(uid,password);

        //what to send in reply
    }

    @Override
    public OwnerRestaurantListResponseDto restaurantList(String uid) {
        List<RestaurantBo> restaurantBos = restaurantsRepoService.getRestaurantListByOwnerUid(uid);
        return boToDtoMapper.getOwnerRestaurantListBoToDto(restaurantBos);
    }

    @Override
    public void createPlaylist(String name, String uid) {

        PlaylistDetailsBo playlistDetailsBo = new PlaylistDetailsBo();
        playlistDetailsBo.setPlaylistName(name);
        playlistDetailsBo.setOwnerUid(uid);
        playlistDetailsBo.setStatus(MusicTrialConstant.ACTIVE);

        playlistDetailsService.savePlayList(playlistDetailsBo);
    }

    @Override
    public PlaylistResponseDto getPlaylist(String uid) {

        final List<PlaylistDetailsBo> playlistDetailsBos = playlistDetailsService
                .getPlaylistByOwnerUid(uid);

        return boToDtoMapper.getPlaylistDto(playlistDetailsBos);

    }

    @Override
    @Transactional
    public void uploadMusicFileInPlayList(MultipartFile multipartFile, String playlistId, String ownerUid) {
        SongsDetailsBo songsDetailsBo = new SongsDetailsBo();

        final String location = fileStorageService.storeFile(multipartFile);

        songsDetailsBo.setSongFormat(multipartFile.getContentType());
        songsDetailsBo = CommonUtils.getSongsInfo(location, songsDetailsBo);
        songsDetailsBo.setSongLocation(location);
        songsDetailsBo.setAdderUid(ownerUid);
        songsDetailsBo.setStatus(MusicTrialConstant.ACTIVE);
        songsDetailsBo.setAuthorize(MusicTrialConstant.ACTIVE);
        songsDetailsBo.setUserType(UserType.OWNER.getType());
        songsDetailsBo  = songsDetailsService.saveSong(songsDetailsBo);

        SongPlaylistDetailsBo songPlaylistDetailsBo = new SongPlaylistDetailsBo();
        songPlaylistDetailsBo.setPlaylistId(Long.valueOf(playlistId));
        songPlaylistDetailsBo.setSongId(songsDetailsBo.getId());
        songPlaylistDetailsService.savePlaylistSong(songPlaylistDetailsBo);

    }

    @Override
    public List<PlaylistSongDto> getPlaylistDescription(String playlistId) {
        List<SongsDetailsBo> songsDetailsBos = songsDetailsService.getAllForPlaylistId(Long.valueOf(playlistId));
        return boToDtoMapper.getPlaylistDetails(songsDetailsBos);

    }

    @Override
    public  List<SongsDetailsResponseDto> setCurrentQueue(String playlistId, String restaurantUid) {

        // not then add all

        List<PlaylistSongUserInfoBo>playlistSongUserInfoBos = songUserInfoService.songsInCurrentQueue(restaurantUid);
        if(!playlistSongUserInfoBos.isEmpty()){
            for (PlaylistSongUserInfoBo playlistSongUserInfoBo:playlistSongUserInfoBos) {
                playlistSongUserInfoBo.setStatus(MusicTrialConstant.INACTIVE);
                playlistSongUserInfoBo.setPlayed(MusicTrialConstant.INACTIVE);
                songUserInfoService.save(playlistSongUserInfoBo);
            }
        }

        //changes From here
        addInUserInfo(songPlaylistDetailsService.getSongsForPlaylist(Long.valueOf(playlistId)),restaurantUid);
        List<SongsInfoModel> songsInfoModels = songsDetailsService.getSongsDetailsForRestaurantUid(restaurantUid);
        return boToDtoMapper.getSongsDetailsDto(songsInfoModels);
        // give queue details separate ?

    }

    @Override
    public void addSongInPlaylist(String songId, String playlistId) {
        if(songPlaylistDetailsService.checkSongIdAndPlaylistId(songId,playlistId)){
            SongPlaylistDetailsBo songPlaylistDetailsBo = new SongPlaylistDetailsBo();
            songPlaylistDetailsBo.setSongId(Long.valueOf(songId));
            songPlaylistDetailsBo.setPlaylistId(Long.valueOf(playlistId));
            songPlaylistDetailsBo.setStatus(MusicTrialConstant.ACTIVE);
            songPlaylistDetailsService.savePlaylistSong(songPlaylistDetailsBo);
        } else {
            throw new RuntimeException("Already Added in Playlist");
        }

    }

    @Override
    public void stopQueue(String restaurantUid) {
        List<PlaylistSongUserInfoBo> playlistSongUserInfoBos =  songUserInfoService.songsInCurrentQueue(restaurantUid);
        for (PlaylistSongUserInfoBo playlistSongUserInfoBo:playlistSongUserInfoBos) {
            playlistSongUserInfoBo.setStatus(MusicTrialConstant.INACTIVE);
            playlistSongUserInfoBo.setPlayed(MusicTrialConstant.INACTIVE);
            songUserInfoService.save(playlistSongUserInfoBo);
        }
    }

    private void addInUserInfo(List<SongPlaylistDetailsBo> songPlaylistDetailsBos, String restaurantUid){
        for (SongPlaylistDetailsBo songPlaylistDetailsBo: songPlaylistDetailsBos) {

            PlaylistSongUserInfoBo playlistSongUserInfoBo = new PlaylistSongUserInfoBo();
            playlistSongUserInfoBo.setDislikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
            playlistSongUserInfoBo.setLikes(MusicTrialConstant.LIKES_DISLIKES_ZERO);
            playlistSongUserInfoBo.setCreatedAt(CommonUtils.getDate());
            playlistSongUserInfoBo.setPlayed(MusicTrialConstant.INACTIVE);
            playlistSongUserInfoBo.setSongId(songPlaylistDetailsBo.getSongId());
            playlistSongUserInfoBo.setStatus(MusicTrialConstant.ACTIVE);
            playlistSongUserInfoBo.setRetaurantUid(restaurantUid);
            songUserInfoService.save(playlistSongUserInfoBo);

        }
    }
}
