package com.example.trial.services;

import com.example.trial.bos.UserBo;
import com.example.trial.dtos.response.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Sign up user sign up response dto.
     *
     * @param userBo the user bo
     * @return the user sign up response dto
     */
    UserSignUpResponseDto signUpUser(UserBo userBo);

    /**
     * Sign in.
     *
     * @param userBo the user bo
     */
    String signIn(UserBo userBo);

    /**
     * Restaurant list restaurant list response dto.
     *
     * @return the restaurant list response dto
     */
    RestaurantListResponseDto restaurantList();


    /**
     * Voting.
     *
     * @param songId the song id
     * @param upVote the up vote
     */
    void voting(String songId, boolean upVote, String userUid);
}
