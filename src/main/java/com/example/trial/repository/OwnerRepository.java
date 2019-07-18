package com.example.trial.repository;

import com.example.trial.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Owner repository.
 */
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

    /**
     * Find by owner uid and password and status owner entity.
     *
     * @param ownerUid the owner uid
     * @param password the password
     * @param status   the status
     * @return the owner entity
     */
    OwnerEntity findByOwnerUidAndPasswordAndStatus(String ownerUid, String password, byte status);
}
