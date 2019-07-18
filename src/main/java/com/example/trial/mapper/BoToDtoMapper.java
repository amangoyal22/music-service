package com.example.trial.mapper;

import com.example.trial.bos.PlaylistDetailsBo;
import com.example.trial.bos.RestaurantBo;
import com.example.trial.bos.SongsDetailsBo;
import com.example.trial.bos.UserBo;
import com.example.trial.dtos.response.*;
import com.example.trial.models.RestaurantDetailsForUserModel;
import com.example.trial.models.SongsInfoModel;

import java.util.List;

/**
 * The interface Bo to dto mapper.
 */
public interface BoToDtoMapper {

    /**
     * Gets songs details dto.
     *
     * @param songsInfoModelList the songs info model list
     * @return the songs details dto
     */
    List<SongsDetailsResponseDto> getSongsDetailsDto(List<SongsInfoModel> songsInfoModelList);

    /**
     * Gets playlist dto.
     *
     * @param restaurantsPlaylistDetailsBos the restaurants playlist details bos
     * @return the playlist dto
     */
    PlaylistResponseDto getPlaylistDto(List<PlaylistDetailsBo> restaurantsPlaylistDetailsBos);

    /**
     * Gets current song dto.
     *
     * @param songId the song id
     * @return the current song dto
     */
    GetNextSongDetailsResponseDto getNextSongDto(Long songId);


    /**
     * Gets user sign up dto.
     *
     * @param userBo the user bo
     * @return the user sign up dto
     */
    UserSignUpResponseDto getUserSignUpDto(UserBo userBo);


    /**
     * Gets restaurant details to dto.
     *
     * @param restaurantDetailsForUserModels the restaurant details for user models
     * @return the restaurant details to dto
     */
    RestaurantListResponseDto getRestaurantDetailsToDto(List<RestaurantDetailsForUserModel>
                                                                restaurantDetailsForUserModels);

    /**
     * Gets playlist details.
     *
     * @param songsDetailsBos the songs details bos
     * @return the playlist details
     */
    List<PlaylistSongDto> getPlaylistDetails(List<SongsDetailsBo> songsDetailsBos);

    /**
     * Gets restaurant list bo to dto.
     *
     * @param restaurantBos the restaurant bos
     * @return the restaurant list bo to dto
     */
    OwnerRestaurantListResponseDto getOwnerRestaurantListBoToDto(List<RestaurantBo> restaurantBos);


    /**
     * Gets songs details dto for search.
     *
     * @param songsDetailsBos the songs details bos
     * @return the songs details dto for search
     */
    SongSearchResultListDto getSongsDetailsDtoForSearch(List<SongsDetailsBo> songsDetailsBos);
}
