package com.example.trial.reposervices;

import com.example.trial.bos.OwnerDetailsBo;

/**
 * The interface Owner repo service.
 */
public interface OwnerRepoService {

    /**
     * Gets details by uid and password.
     *
     * @param uid      the uid
     * @param password the password
     * @return the details by uid and password
     */
    OwnerDetailsBo getDetailsByUidAndPassword(String uid, String password);
}
