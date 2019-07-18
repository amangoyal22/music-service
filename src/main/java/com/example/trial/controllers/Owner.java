package com.example.trial.controllers;

import com.example.trial.constant.ResponseConstant;
import com.example.trial.dtos.ResponseDto;
import com.example.trial.dtos.request.*;
import com.example.trial.dtos.response.*;
import com.example.trial.services.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The type Owner.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/owner")
public class Owner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Owner.class);

    /**
     * The Owner service.
     */
    @Autowired
    private OwnerService ownerService;

    /**
     * Login response entity.
     *
     * @param ownerLoginRequestDto the owner login request dto
     * @return the response entity
     */
    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity login(@RequestBody final OwnerLoginRequestDto ownerLoginRequestDto) {
        ResponseDto responseDto;
        LOGGER.info("Owner Login API Called");

        try {

            ownerService.login(ownerLoginRequestDto.getOwnerUid(), ownerLoginRequestDto.getOwnerPassword());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {

            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Restaurant list response entity.
     *
     * @param ownerRestaurantListRequestDto the owner restaurant list request dto
     * @return the response entity
     */
    @PostMapping(value = "/restaurantList", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity restaurantList(@RequestBody OwnerRestaurantListRequestDto ownerRestaurantListRequestDto) {

        LOGGER.info("Owner Get Restaurant Api Called");
        ResponseDto responseDto;
        OwnerRestaurantListResponseDto ownerRestaurantListResponseDto = null;

        try {

            ownerRestaurantListResponseDto = ownerService.restaurantList(ownerRestaurantListRequestDto.getOwnerUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, ownerRestaurantListResponseDto);

        } catch (Exception exp) {

            LOGGER.error("Error Occured: {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Create playlist response entity.
     *
     * @param createPlaylistRequestDto the create playlist request dto
     * @return the response entity
     */
    @PostMapping("/createPlaylist")
    public ResponseEntity createPlaylist(@RequestBody final CreatePlaylistRequestDto createPlaylistRequestDto) {

        ResponseDto responseDto;
        LOGGER.info("Owner Create Playlist API Called");

        try {


            ownerService.createPlaylist(createPlaylistRequestDto.getPlaylistName(),
                    createPlaylistRequestDto.getOwnerUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Gets playlist.
     *
     * @param getPlaylistRequestDto the get playlist request dto
     * @return the playlist
     */
    @PostMapping("/getPlaylists")
    public ResponseEntity getPlaylist(@RequestBody final GetPlaylistRequestDto getPlaylistRequestDto) {

        LOGGER.info("Owner Get Playlist List API Called");
        ResponseDto responseDto;

        try {

            PlaylistResponseDto playlistResponseDto = ownerService.getPlaylist(getPlaylistRequestDto.getOwnerUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, playlistResponseDto);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Upload file response entity.
     *
     * @param file       the file
     * @param playlistId the playlist id
     * @param ownerUid   the owner uid
     * @return the response entity
     */
    @PostMapping("/uploadFileInPlaylist")
    public ResponseEntity uploadFileInPlaylist(@RequestParam("file") MultipartFile file,
                                               @RequestParam("playlistId") String playlistId,
                                               @RequestParam("ownerUid") String ownerUid) {
        ResponseDto responseDto;
        LOGGER.info("Owner Music Upload API Called");

        try {

            ownerService.uploadMusicFileInPlayList(file, playlistId, ownerUid);
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);

        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Playlist details response entity.
     *
     * @param getPlaylistDetailsRequestDto the get playlist details request dto
     * @return the response entity
     */
    @PostMapping(value = "/playlistDescription", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity playlistDescription(@RequestBody GetPlaylistDetailsRequestDto getPlaylistDetailsRequestDto) {

        ResponseDto responseDto;
        LOGGER.info("Owner Playlist Details API Called");

        try {

            List<PlaylistSongDto> playlistSongDtos = ownerService.getPlaylistDescription(getPlaylistDetailsRequestDto
                    .getPlaylistId());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, playlistSongDtos);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, "Internal Server Error", null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Sets queue.
     *
     * @param setQueueRequestDto the set queue request dto
     * @return the queue
     */
    @PostMapping(value = "/setQueue", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity setQueue(@RequestBody SetQueueRequestDto setQueueRequestDto) {

        LOGGER.info("Owner Set Queue API Called");
        ResponseDto responseDto;

        try {
            ownerService.setCurrentQueue(setQueueRequestDto.getPlaylistId(), setQueueRequestDto.getRestaurantUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Sets queue.
     *
     * @param addSongInPlaylistRequestDto the add song request dto
     * @return the queue
     */
    @PostMapping(value = "/addExistingSongInPlaylist", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addExistingSongInPlaylist(@RequestBody AddSongInPlaylistRequestDto addSongInPlaylistRequestDto) {

        LOGGER.info("Owner add Existing Song In Playlist Called");
        ResponseDto responseDto;

        try {
            ownerService.addSongInPlaylist(addSongInPlaylistRequestDto.getSongId(),
                    addSongInPlaylistRequestDto.getPlaylistId());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PostMapping(value = "/stopQueue", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity setQueue(@RequestBody StopQueueRequestDto stopQueueRequestDto) {

        LOGGER.info("Owner Stop Queue API Called");
        ResponseDto responseDto;

        try {
            ownerService.stopQueue(stopQueueRequestDto.getRestaurantUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



}
