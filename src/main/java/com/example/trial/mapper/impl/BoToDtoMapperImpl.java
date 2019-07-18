package com.example.trial.mapper.impl;

import com.example.trial.bos.PlaylistDetailsBo;
import com.example.trial.bos.RestaurantBo;
import com.example.trial.bos.SongsDetailsBo;
import com.example.trial.bos.UserBo;
import com.example.trial.dtos.response.*;
import com.example.trial.mapper.BoToDtoMapper;
import com.example.trial.models.RestaurantDetailsForUserModel;
import com.example.trial.models.SongsInfoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Bo to dto mapper.
 */
@Service
public class BoToDtoMapperImpl implements BoToDtoMapper {

    @Override
    public List<SongsDetailsResponseDto> getSongsDetailsDto(List<SongsInfoModel> songsInfoModelList) {

        if (songsInfoModelList == null) {
            return null;
        }

        List<SongsDetailsResponseDto> list = new ArrayList<SongsDetailsResponseDto>(songsInfoModelList.size());
        for (SongsInfoModel songsInfoModel : songsInfoModelList) {
            list.add(songsInfoModelToSongsDetailsResponseDto(songsInfoModel));
        }

        return list;
    }

    @Override
    public PlaylistResponseDto getPlaylistDto(final List<PlaylistDetailsBo> restaurantsPlaylistDetailsBos) {

        final PlaylistResponseDto playlistResponseDto = new PlaylistResponseDto();

        List<PlaylistDetailsDto> playlistList = new ArrayList<>(restaurantsPlaylistDetailsBos.size());

        if (restaurantsPlaylistDetailsBos.size() == 0) {
            playlistResponseDto.setPlaylist(playlistList);
        }

        for (PlaylistDetailsBo restaurantsPlaylistDetailsBo : restaurantsPlaylistDetailsBos) {
            PlaylistDetailsDto playlistDetailsDto = new PlaylistDetailsDto();
            playlistDetailsDto.setId(restaurantsPlaylistDetailsBo.getId());
            playlistDetailsDto.setName(restaurantsPlaylistDetailsBo.getPlaylistName());
            playlistList.add(playlistDetailsDto);
        }

        playlistResponseDto.setPlaylist(playlistList);
        return playlistResponseDto;
    }

    @Override
    public GetNextSongDetailsResponseDto getNextSongDto(Long songId) {
        GetNextSongDetailsResponseDto getNextSongDetailsResponseDto = new GetNextSongDetailsResponseDto();
        getNextSongDetailsResponseDto.setSongId(songId);
        return getNextSongDetailsResponseDto;
    }

    @Override
    public UserSignUpResponseDto getUserSignUpDto(UserBo userBo) {
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();
        userSignUpResponseDto.setName(userBo.getName());
        userSignUpResponseDto.setUserUid(userBo.getUserUid());
        return userSignUpResponseDto;
    }

    @Override
    public RestaurantListResponseDto getRestaurantDetailsToDto(List<RestaurantDetailsForUserModel>
                                                                       restaurantDetailsForUserModels) {
        RestaurantListResponseDto restaurantListResponseDto = new RestaurantListResponseDto();

        List<RestaurantDetailsDto> restaurantDetailsDtos = new ArrayList<>(restaurantDetailsForUserModels.size());
        for (RestaurantDetailsForUserModel restaurantDetailsForUserModel : restaurantDetailsForUserModels) {
            restaurantDetailsDtos.add(restaurantModelToRestaurantDetailsDto(restaurantDetailsForUserModel));
        }

        restaurantListResponseDto.setRestaurantDetails(restaurantDetailsDtos);
        return restaurantListResponseDto;
    }

    @Override
    public List<PlaylistSongDto> getPlaylistDetails(List<SongsDetailsBo> songsDetailsBos) {

        List<PlaylistSongDto> playlistSongDtos = new ArrayList<>(songsDetailsBos.size());
        for (SongsDetailsBo songsDetailsBo : songsDetailsBos) {
            playlistSongDtos.add(songsInfoModelToPlaylistSongDto(songsDetailsBo));
        }

        return playlistSongDtos;
    }

    @Override
    public OwnerRestaurantListResponseDto getOwnerRestaurantListBoToDto(List<RestaurantBo> restaurantBos) {
        OwnerRestaurantListResponseDto ownerRestaurantListResponseDto = new OwnerRestaurantListResponseDto();
        List<OwnerRestaurantDetailDto> ownerRestaurantDetailDtos = new ArrayList<>(restaurantBos.size());
        for (RestaurantBo restaurantBo : restaurantBos) {
            ownerRestaurantDetailDtos.add(restaurantBoToDto(restaurantBo));
        }
        ownerRestaurantListResponseDto.setOwnerRestaurantDetailDto(ownerRestaurantDetailDtos);
        return ownerRestaurantListResponseDto;
    }


    @Override
    public SongSearchResultListDto getSongsDetailsDtoForSearch(List<SongsDetailsBo> songsDetailsBos) {

        if (songsDetailsBos == null) {
            return null;
        }

        List<SongsSearchDetails> list = new ArrayList<SongsSearchDetails>(songsDetailsBos.size());
        for (SongsDetailsBo songsDetailsBo : songsDetailsBos) {
            list.add(songsBoToSongsSearchDetails(songsDetailsBo));
        }
        SongSearchResultListDto songSearchResultListDto = new SongSearchResultListDto();
        songSearchResultListDto.setSongsSearchDetails(list);
        return songSearchResultListDto;
    }

    /**
     * Songs info model to songs list response dto songs list response dto.
     *
     * @param songsInfoModel the songs info model
     * @return the songs list response dto
     */
    protected SongsDetailsResponseDto songsInfoModelToSongsDetailsResponseDto(SongsInfoModel songsInfoModel) {
        if (songsInfoModel == null) {
            return null;
        }

        SongsDetailsResponseDto songsDetailsResponseDto = new SongsDetailsResponseDto();

        songsDetailsResponseDto.setLikes(songsInfoModel.getLikes());
        songsDetailsResponseDto.setDislikes(songsInfoModel.getDislikes());
        songsDetailsResponseDto.setGenre(songsInfoModel.getGenre());
        songsDetailsResponseDto.setLength(songsInfoModel.getLength());
        songsDetailsResponseDto.setName(songsInfoModel.getName());
        songsDetailsResponseDto.setLocation(songsInfoModel.getLocation());
        songsDetailsResponseDto.setId(songsInfoModel.getId());
        songsDetailsResponseDto.setIsCurrent(songsInfoModel.getIsCurrent());

        return songsDetailsResponseDto;
    }


    /**
     * Restaurant model to restaurant details dto restaurant details dto.
     *
     * @param restaurantDetailsForUserModel the restaurant details for user model
     * @return the restaurant details dto
     */
    protected RestaurantDetailsDto restaurantModelToRestaurantDetailsDto(RestaurantDetailsForUserModel
                                                                                 restaurantDetailsForUserModel) {
        if (restaurantDetailsForUserModel == null) {
            return null;
        }

        RestaurantDetailsDto restaurantDetailsDto = new RestaurantDetailsDto();

        restaurantDetailsDto.setRestaurantLocation(restaurantDetailsForUserModel.getRestaurantLocation());
        restaurantDetailsDto.setRestaurantLogo(restaurantDetailsForUserModel.getRestaurantLogo());
        restaurantDetailsDto.setRestaurantName(restaurantDetailsForUserModel.getRestaurantName());
        restaurantDetailsDto.setRestaurantOwner(restaurantDetailsForUserModel.getRestaurantOwner());
        restaurantDetailsDto.setRestaurantUid(restaurantDetailsForUserModel.getRestaurantUid());

        return restaurantDetailsDto;
    }

    /**
     * Songs info model to playlist song dto playlist song dto.
     *
     * @param songsDetailsBo the songs details bo
     * @return the playlist song dto
     */
    protected PlaylistSongDto songsInfoModelToPlaylistSongDto(SongsDetailsBo songsDetailsBo) {
        if (songsDetailsBo == null) {
            return null;
        }

        PlaylistSongDto playlistSongDto = new PlaylistSongDto();

        playlistSongDto.setGenre(songsDetailsBo.getSongGenre());
        playlistSongDto.setLength(songsDetailsBo.getSongLength());
        playlistSongDto.setName(songsDetailsBo.getSongName());
        playlistSongDto.setId(songsDetailsBo.getId());
        playlistSongDto.setLocation(songsDetailsBo.getSongLocation());

        return playlistSongDto;
    }

    /**
     * Restaurant bo to dto owner restaurant detail dto.
     *
     * @param restaurantBo the restaurant bo
     * @return the owner restaurant detail dto
     */
    protected OwnerRestaurantDetailDto restaurantBoToDto(RestaurantBo restaurantBo){
        OwnerRestaurantDetailDto ownerRestaurantDetailDto = new OwnerRestaurantDetailDto();
        ownerRestaurantDetailDto.setRestaurantLocation(restaurantBo.getRestaurantLocation());
        ownerRestaurantDetailDto.setRestaurantLogo(restaurantBo.getRestaurantLogo());
        ownerRestaurantDetailDto.setRestaurantName(restaurantBo.getRestaurantName());
        ownerRestaurantDetailDto.setRestaurantUid(restaurantBo.getRestaurantUid());
        return ownerRestaurantDetailDto;

    }


    protected SongsSearchDetails songsBoToSongsSearchDetails(SongsDetailsBo songsDetailsBo) {
        if (songsDetailsBo == null) {
            return null;
        }

        SongsSearchDetails songsSearchDetails = new SongsSearchDetails();

        songsSearchDetails.setGenre(songsDetailsBo.getSongGenre());
        songsSearchDetails.setLength(songsDetailsBo.getSongLength());
        songsSearchDetails.setName(songsDetailsBo.getSongName());
        songsSearchDetails.setLocation(songsDetailsBo.getSongLocation());
        songsSearchDetails.setId(songsDetailsBo.getId());


        return songsSearchDetails;
    }

}
