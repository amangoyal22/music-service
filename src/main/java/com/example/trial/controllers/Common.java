package com.example.trial.controllers;

import com.example.trial.constant.ResponseConstant;
import com.example.trial.dtos.ResponseDto;
import com.example.trial.dtos.request.*;
import com.example.trial.dtos.response.GetNextSongDetailsResponseDto;
import com.example.trial.dtos.response.SongSearchResultListDto;
import com.example.trial.dtos.response.SongsDetailsResponseDto;
import com.example.trial.services.CommonService;
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
 * The type Common.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/common")
public class Common {
    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Common.class);

    /**
     * The Common service.
     */
    @Autowired
    private CommonService commonService;

    /**
     * Playlist details response entity.
     *
     * @param currentQueueRequestDto the current queue request dto
     * @return the response entity
     */
    @PostMapping(value = "/currentQueue", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity currentQueue(@RequestBody CurrentQueueRequestDto currentQueueRequestDto) {

        LOGGER.info("Common Queue Details API Called");

        ResponseDto responseDto;

        try {

            List<SongsDetailsResponseDto> songsDetailsResponseDtos = commonService
                    .queueDetails(currentQueueRequestDto.getRestaurantUid());

            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, songsDetailsResponseDtos);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Gets next song.and update the last one.
     *
     * @param nextSongDetailsRequestDto the update song details request dto
     * @return the next song
     */
    @PostMapping(value = "/nextSong", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getNextSong(@RequestBody final NextSongDetailsRequestDto nextSongDetailsRequestDto) {

        ResponseDto responseDto;
        GetNextSongDetailsResponseDto getNextSongDetailsResponseDto;
        LOGGER.info("Common Current Song Update and Next Song API Called");

        try {

            getNextSongDetailsResponseDto = commonService.updateAndNextSongRecord(nextSongDetailsRequestDto.getRestaurantUid());

            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, getNextSongDetailsResponseDto);


        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Upload file response entity.
     *
     * @param file          the file
     * @param restaurantUid the restaurant uid
     * @param adderUid      the adder uid - the person who is adding the song.
     * @return the response entity
     */
    @PostMapping("/uploadFileInQueue")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,
                                     @RequestParam("restaurantUid") String restaurantUid,
                                     @RequestParam("adderUid") String adderUid) {
        ResponseDto responseDto;
        LOGGER.info("Common Music Upload In Queue API Called");

        try {

            commonService.uploadMusicFileInQueue(file, restaurantUid,adderUid);
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error Occured: {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Upload file response entity.
     *
     * @param searchSongRequestDto the search song request dto
     * @return the response entity
     */
    @PostMapping("/searchSong")
    public ResponseEntity uploadFile(@RequestBody final SearchSongRequestDto searchSongRequestDto) {
        ResponseDto responseDto;
        LOGGER.info("Common Music Upload In Queue API Called");

        try {

            SongSearchResultListDto songSearchResultListDto = commonService
                    .searchSong(searchSongRequestDto.getSearchKey());

            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, songSearchResultListDto);

        } catch (Exception exp) {
            LOGGER.error("Error Occured: {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Sets queue.
     *
     * @param addSongInQueueRequestDto the add song in queue request dto
     * @return the queue
     */
    @PostMapping(value = "/addExistingSongInQueue", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addExistingSongInQueue(@RequestBody AddSongInQueueRequestDto addSongInQueueRequestDto) {

        LOGGER.info("Common Queue Details API Called");
        ResponseDto responseDto;

        try {
            commonService.addSongInQueue(addSongInQueueRequestDto.getSongId(),
                    addSongInQueueRequestDto.getRestaurantUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS, null);

        } catch (Exception exp) {
            LOGGER.error("Error : {}", exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED, exp.getMessage(), null);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
