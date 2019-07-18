package com.example.trial.repository;

import com.example.trial.entity.PlaylistDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Restaurants playlist details repository.
 */
@Repository
public interface PlaylistDetailsRepository extends JpaRepository<PlaylistDetailsEntity, Long> {

    /**
     * Find by restaurant uid and status list.
     *
     * @param restaurantUid the restaurant uid
     * @param status        the status
     * @return the list
     */
    List<PlaylistDetailsEntity> findByOwnerUidAndStatus(String restaurantUid, byte status);

}
