package com.example.trial.repository;

import com.example.trial.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface UserBo respositry.
 */
/*
 * Created by Aman Goyal on 2019-07-10. Don't mess with this!
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find by user uid user entity.
     *
     * @param userUid the user uid
     * @param status  the status
     * @return the user entity
     */
    UserEntity findByUserUidAndStatus(String userUid, byte status);

    /**
     * Find by email or mobile user entity.
     *
     * @param email  the email
     * @param mobile the mobile
     * @param status the status
     * @return the user entity
     */
    UserEntity findFirstByEmailOrMobileAndStatus(String email, String mobile, byte status);


    /**
     * Find by email and password user entity.
     *
     * @param email    the email
     * @param password the password
     * @param status   the status
     * @return the user entity
     */
    UserEntity findByEmailAndPasswordAndStatus(String email, String password, byte status);

}
