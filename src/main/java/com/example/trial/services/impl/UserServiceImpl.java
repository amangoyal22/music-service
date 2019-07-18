package com.example.trial.services.impl;

import com.example.trial.bos.*;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.dtos.response.*;
import com.example.trial.mapper.BoToDtoMapper;
import com.example.trial.models.RestaurantDetailsForUserModel;
import com.example.trial.reposervices.RestaurantsRepoService;
import com.example.trial.reposervices.SongUserInfoService;
import com.example.trial.reposervices.UserRepoService;
import com.example.trial.services.*;
import com.example.trial.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The User repo service.
     */
    @Autowired
    private UserRepoService userRepoService;

    /**
     * The Bo to dto mapper.
     */
    @Autowired
    private BoToDtoMapper boToDtoMapper;

    /**
     * The Restaurants service.
     */
    @Autowired
    private RestaurantsRepoService restaurantsRepoService;

    /**
     * The Song user info service.
     */
    @Autowired
    private SongUserInfoService songUserInfoService;

    /**
     * The Redis service.
     */
    @Autowired
    private RedisService redisService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @Override
    public UserSignUpResponseDto signUpUser(UserBo userBo) {
        //uid

        if (Objects.nonNull(userRepoService.checkEmailOrMobile(userBo.getEmail(), userBo.getMobile()))) {
            throw new RuntimeException("Given Email or Mobile Number is already registered.");
        }
        getUserUid(userBo);
        userBo.setStatus(MusicTrialConstant.ACTIVE);
        userBo = userRepoService.saveUser(userBo);
        return boToDtoMapper.getUserSignUpDto(userBo);
    }

    @Override
    public String signIn(UserBo userBo) {
        userBo = userRepoService.login(userBo.getEmail(), userBo.getPassword());
        return userBo.getUserUid();
    }

    @Override
    public RestaurantListResponseDto restaurantList() {

        List<RestaurantDetailsForUserModel> restaurantDetailsForUserModels = restaurantsRepoService.getRestaurantList();
        //getDetailsMapped(restaurantDetailsForUserModels, restaurantBos);
        return boToDtoMapper.getRestaurantDetailsToDto(restaurantDetailsForUserModels);
    }

    @Override
    public void voting(String songId, boolean upVote, String userUid) {
        boolean resultUpVote = redisService.checkUserLikeVote(userUid, Long.valueOf(songId));
        boolean resultDownVote = redisService.checkUserUnlikeVote(userUid, Long.valueOf(songId));

        if (resultUpVote && upVote || resultDownVote && !upVote) {

            LOGGER.info("User {} Voted Before For the SongId {}", userUid, songId);
            throw new RuntimeException("Already Voted For the same");

        } else if (resultDownVote && upVote || resultUpVote && !upVote) {

            LOGGER.info("User {} has Change of heart For the SongId {}", userUid, songId);
            songUserInfoService.doVote(songId, upVote, true);//add vote
            redisService.addUser(userUid, Long.valueOf(songId), upVote);
            songUserInfoService.doVote(songId, !upVote, false); //subract vote
            redisService.deleteUser(userUid, Long.valueOf(songId), !upVote);

        } else if (resultDownVote == resultUpVote && resultDownVote == false) {

            LOGGER.info("User {} First Response For SongId {}", userUid, songId);
            songUserInfoService.doVote(songId, upVote, true); // add vote
            redisService.addUser(userUid, Long.valueOf(songId), upVote);

        }

    }

    private void getUserUid(UserBo userBo) {
        String uid = CommonUtils.getUid();
        while (true) {
            if (Objects.isNull(userRepoService.checkUserUid(uid))) {
                break;
            }
            uid = CommonUtils.getUid();
        }
        userBo.setUserUid(uid);
    }

//    private void getDetailsMapped(final List<RestaurantDetailsForUserModel> restaurantDetailsForUserModels,
//                             final List<RestaurantBo> restaurantBos) {
//
//        for (final RestaurantBo restaurantBo : restaurantBos) {
//            RestaurantDetailsForUserModel restaurantDetailsForUserModel = new RestaurantDetailsForUserModel();
//            restaurantDetailsForUserModel.setRestaurantLocation(restaurantBo.getRestaurantLocation());
//            restaurantDetailsForUserModel.setRestaurantLogo(restaurantBo.getRestaurantLogo());
//            restaurantDetailsForUserModel.setRestaurantName(restaurantBo.getRestaurantName());
//            restaurantDetailsForUserModel.setRestaurantOwner(restaurantBo.getRestaurantOwner());
//            restaurantDetailsForUserModel.setRestaurantUid(restaurantBo.getRestaurantUid());
//            restaurantDetailsForUserModels.add(restaurantDetailsForUserModel);
//        }
//    }
}
