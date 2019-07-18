package com.example.trial.reposervices.impl;

import com.example.trial.bos.RestaurantBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.models.RestaurantDetailsForUserModel;
import com.example.trial.repository.RestaurantsRepository;
import com.example.trial.reposervices.RestaurantsRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Restaurants service.
 */
@Service
public class RestaurantsRepoServiceImpl implements RestaurantsRepoService {

    /**
     * The Restaurants repository.
     */
    @Autowired
    private RestaurantsRepository restaurantsRepository;

    /**
     * The Entity bo mapper.
     */
    @Autowired
    private EntityBoMapper entityBoMapper;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantsRepoService.class);


    @Override
    public List<RestaurantDetailsForUserModel> getRestaurantList() {

        return restaurantsRepository.findRestaurantDetails();

    }

    @Override
    public List<RestaurantBo> getRestaurantListByOwnerUid(String ownerUid) {

        return entityBoMapper.restaurantEntityListToBo(restaurantsRepository.findByOwnerUidAndStatus(ownerUid,
                MusicTrialConstant.ACTIVE));
    }
}
