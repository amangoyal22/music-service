package com.example.trial.reposervices;

import com.example.trial.bos.RestaurantBo;
import com.example.trial.models.RestaurantDetailsForUserModel;

import java.util.List;

/**
 * The interface Restaurants service.
 */
public interface RestaurantsRepoService {
    /**
     * Gets restaurant list.
     *
     * @return the restaurant list
     */
    List<RestaurantDetailsForUserModel> getRestaurantList();

    /**
     * Gets restaurant list by owner uid.
     *
     * @param ownerUid the owner uid
     * @return the restaurant list by owner uid
     */
    List<RestaurantBo> getRestaurantListByOwnerUid(String ownerUid);

}
