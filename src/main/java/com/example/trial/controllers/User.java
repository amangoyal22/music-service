package com.example.trial.controllers;

import com.example.trial.constant.ResponseConstant;
import com.example.trial.dtos.ResponseDto;
import com.example.trial.dtos.request.*;
import com.example.trial.dtos.response.*;
import com.example.trial.mapper.DtoToBoMapper;
import com.example.trial.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    /**
     * The User service.
     */
    @Autowired
    private UserService userService;

    /**
     * The Dto to bo mapper.
     */
    @Autowired
    private DtoToBoMapper dtoToBoMapper;


    /**
     * Sign up response entity.
     *
     * @param userSignUpRequestDto the user sign up dto
     * @return the response entity
     */
    @PostMapping(value = "/signup", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {

        LOGGER.info("User Signup API Called");

        ResponseDto responseDto;
        UserSignUpResponseDto userSignUpResponseDto;
        try {

            userSignUpResponseDto = userService.signUpUser(dtoToBoMapper.getUserSignUpDtoToBo(userSignUpRequestDto));

            responseDto = new ResponseDto(ResponseConstant.SUCCESS,ResponseConstant.SUCCESS,userSignUpResponseDto);

        } catch (Exception exp) {
            LOGGER.error("Error Occured: {}",exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED,exp.getMessage(),null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Login response entity.
     *
     * @param userSignInRequestDto the user sign in request dto
     * @return the response entity
     */
    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity login(@RequestBody UserSignInRequestDto userSignInRequestDto) {

        LOGGER.info("User Login API Called");
        ResponseDto responseDto;
        try {

            String userUid  = userService.signIn(dtoToBoMapper.getUserSignInDtoToBo(userSignInRequestDto));
            responseDto = new ResponseDto(ResponseConstant.SUCCESS,ResponseConstant.SUCCESS,userUid);

        } catch (Exception exp) {
            LOGGER.error("Error Occured: {}",exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED,exp.getMessage(),null);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Restaurant list response entity.
     *
     * @return the response entity
     */
    @GetMapping(value = "/restaurantList", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity restaurantList() {

        LOGGER.info("User Get Restaurant Api Called");
        ResponseDto responseDto;
        RestaurantListResponseDto restaurantListResponseDto = null;

        try {

            restaurantListResponseDto = userService.restaurantList();
            responseDto = new ResponseDto(ResponseConstant.SUCCESS,ResponseConstant.SUCCESS,restaurantListResponseDto);

        } catch (Exception exp) {

            LOGGER.error("Error Occured: {}",exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED,exp.getMessage(),null);

        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    /**
     * Do vote response entity.
     *
     * @param voteRequestDto the vote request dto
     * @return the response entity
     */
    @PostMapping(value = "/vote", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity doVote(@RequestBody final VoteRequestDto voteRequestDto) {

        ResponseDto responseDto;
        LOGGER.info("User Vote Called");

        try {

            userService.voting(voteRequestDto.getSongId(), voteRequestDto.isUpVote(),voteRequestDto.getUserUid(),
                    voteRequestDto.getRestaurantUid());
            responseDto = new ResponseDto(ResponseConstant.SUCCESS,ResponseConstant.SUCCESS,null);

        } catch (Exception exp) {
            LOGGER.error("Error Occured: {}",exp.getMessage());
            responseDto = new ResponseDto(ResponseConstant.FAILED,exp.getMessage(),null);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
