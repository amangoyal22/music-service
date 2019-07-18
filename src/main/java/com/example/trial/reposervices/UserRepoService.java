package com.example.trial.reposervices;

import com.example.trial.bos.UserBo;

/**
 * The interface User repo service.
 */
public interface UserRepoService {
    /**
     * Save user user bo.
     *
     * @param userBo the user bo
     * @return the user bo
     */
    UserBo saveUser(UserBo userBo);

    /**
     * Check user uid user bo.
     *
     * @param userUid the user uid
     * @return the user bo
     */
    UserBo checkUserUid(String userUid);


    /**
     * Login user bo.
     *
     * @param emailId  the email id
     * @param password the password
     * @return the user bo
     */
    UserBo login(String emailId, String password);

    /**
     * Check email or mobile user bo.
     *
     * @param email  the email
     * @param mobile the mobile
     * @return the user bo
     */
    UserBo checkEmailOrMobile(String email,String mobile);
}
