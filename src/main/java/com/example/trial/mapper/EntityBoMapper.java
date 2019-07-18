package com.example.trial.mapper;

import com.example.trial.bos.*;
import com.example.trial.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Entity bo mapper.
 */
@Mapper(componentModel = "spring")
public interface EntityBoMapper {

    /**
     * Songs details bo to entity songs details entity.
     *
     * @param songsDetailsBo the songs details bo
     * @return the songs details entity
     */
    SongsDetailsEntity songsDetailsBoToEntity(SongsDetailsBo songsDetailsBo);

    /**
     * Playlist song user info bo to entity playlist song user info entity.
     *
     * @param playlistSongUserInfoBo the playlist song user info bo
     * @return the playlist song user info entity
     */
    PlaylistSongUserInfoEntity playlistSongUserInfoBoToEntity(PlaylistSongUserInfoBo playlistSongUserInfoBo);

    /**
     * Restaurants playlist details bo to entity restaurants playlist details entity.
     *
     * @param restaurantsPlaylistDetailsBo the restaurants playlist details bo
     * @return the restaurants playlist details entity
     */
    PlaylistDetailsEntity restaurantsPlaylistDetailsBoToEntity(PlaylistDetailsBo restaurantsPlaylistDetailsBo);

    /**
     * User bo to entity user entity.
     *
     * @param userBo the user bo
     * @return the user entity
     */
    UserEntity userBoToEntity(UserBo userBo);

    /**
     * Songs details entity to bo songs details bo.
     *
     * @param playlistSongsDetailsEntity the playlist songs details entity
     * @return the songs details bo
     */
    SongsDetailsBo songsDetailsEntityToBo(SongsDetailsEntity playlistSongsDetailsEntity);

    /**
     * Playlist song user info entity to bo playlist song user info bo.
     *
     * @param playlistSongUserInfoEntity the playlist song user info entity
     * @return the playlist song user info bo
     */
    PlaylistSongUserInfoBo playlistSongUserInfoEntityToBo(PlaylistSongUserInfoEntity playlistSongUserInfoEntity);

    /**
     * Restaurant entity to bo restaurant bo.
     *
     * @param restaurantEntity the restaurant entity
     * @return the restaurant bo
     */
    RestaurantBo restaurantEntityToBo(RestaurantEntity restaurantEntity);

    /**
     * Restaurants playlist details entity to bo restaurants playlist details bo.
     *
     * @param restaurantsPlaylistDetailsEntity the restaurants playlist details entity
     * @return the restaurants playlist details bo
     */
    PlaylistDetailsBo restaurantsPlaylistDetailsEntityToBo(PlaylistDetailsEntity
                                                                              restaurantsPlaylistDetailsEntity);

    /**
     * Restaurants playlist details list entity to bo list.
     *
     * @param restaurantsPlaylistDetailsEntityList the restaurants playlist details entity list
     * @return the list
     */
    List<PlaylistDetailsBo> restaurantsPlaylistDetailsListEntityToBo(List<PlaylistDetailsEntity>
                                                                              restaurantsPlaylistDetailsEntityList);

    /**
     * User entity to bo user bo.
     *
     * @param userEntity the user entity
     * @return the user bo
     */
    UserBo userEntityToBo(UserEntity userEntity);

    /**
     * Restaurant entity list to bo list.
     *
     * @param restaurantEntity the restaurant entity
     * @return the list
     */
    List<RestaurantBo> restaurantEntityListToBo(List<RestaurantEntity> restaurantEntity);


    /**
     * Songs details list entity to bo list.
     *
     * @param playlistSongsDetailsEntity the playlist songs details entity
     * @return the list
     */
    List<SongsDetailsBo> songsDetailsListEntityToBo(List<SongsDetailsEntity> playlistSongsDetailsEntity);

    /**
     * Gets owner details entity to bo.
     *
     * @param ownerEntity the owner entity
     * @return the owner details entity to bo
     */
    OwnerDetailsBo getOwnerDetailsEntityToBo(OwnerEntity ownerEntity);

    /**
     * Playlist song user info bo to entity list.
     *
     * @param playlistSongUserInfoEntity the playlist song user info entity
     * @return the list
     */
    List<PlaylistSongUserInfoBo> playlistSongUserInfoEntityListToBo(List<PlaylistSongUserInfoEntity>
                                                                        playlistSongUserInfoEntity);

    /**
     * Song playlist details bo to entity song playlist details entity.
     *
     * @param songPlaylistDetailsBo the song playlist details bo
     * @return the song playlist details entity
     */
    SongPlaylistDetailsEntity songPlaylistDetailsBoToEntity(SongPlaylistDetailsBo songPlaylistDetailsBo);

    /**
     * Song playlist details entity to bo song playlist details bo.
     *
     * @param songPlaylistDetailsEntity the song playlist details entity
     * @return the song playlist details bo
     */
    SongPlaylistDetailsBo songPlaylistDetailsEntityToBo(SongPlaylistDetailsEntity songPlaylistDetailsEntity);

    /**
     * Song playlist details entity list to bo list.
     *
     * @param songPlaylistDetailsEntity the song playlist details entity
     * @return the list
     */
    List<SongPlaylistDetailsBo> songPlaylistDetailsEntityListToBo(List<SongPlaylistDetailsEntity> songPlaylistDetailsEntity);



}
