package com.example.trial.repository;

import com.example.trial.entity.RestaurantEntity;
import com.example.trial.models.RestaurantDetailsForUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Restaurants repository.
 */
@Repository
public interface RestaurantsRepository extends JpaRepository<RestaurantEntity, Long> {


    /**
     * Find restaurant details list.
     *
     * @return the list
     */
    @Query(nativeQuery = true)
    List<RestaurantDetailsForUserModel> findRestaurantDetails();

    /**
     * Find by owner uid and status list.
     *
     * @param uid    the uid
     * @param status the status
     * @return the list
     */
    List<RestaurantEntity> findByOwnerUidAndStatus(String uid,byte status);

}
