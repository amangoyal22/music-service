package com.example.trial.reposervices.impl;

import com.example.trial.bos.OwnerDetailsBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.OwnerEntity;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.repository.OwnerRepository;
import com.example.trial.reposervices.OwnerRepoService;
import com.example.trial.reposervices.RestaurantsRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type Owner repo service.
 */
@Service
public class OwnerRepoServiceImpl implements OwnerRepoService {

    /**
     * The Owner repository.
     */
    @Autowired
    private OwnerRepository ownerRepository;

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
    public OwnerDetailsBo getDetailsByUidAndPassword(String uid, String password) {
        OwnerEntity ownerEntity = ownerRepository
                .findByOwnerUidAndPasswordAndStatus(uid, password, MusicTrialConstant.ACTIVE);
        if (Objects.isNull(ownerEntity)) {
            LOGGER.info("Restaurant Details don't exist or Password is Incorrect for uid: {}", uid);
            throw new RuntimeException("Restaurant Details don't exist or Password is Incorrect");
        }

        return entityBoMapper.getOwnerDetailsEntityToBo(ownerEntity);
    }
}
