package com.example.trial.reposervices.impl;

import com.example.trial.bos.UserBo;
import com.example.trial.constant.MusicTrialConstant;
import com.example.trial.entity.UserEntity;
import com.example.trial.mapper.EntityBoMapper;
import com.example.trial.repository.UserRepository;
import com.example.trial.reposervices.RestaurantsRepoService;
import com.example.trial.reposervices.UserRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type User repo service.
 */
@Service
public class UserRepoServiceImpl implements UserRepoService {

    /**
     * The User repository.
     */
    @Autowired
    private UserRepository userRepository;

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
    public UserBo saveUser(UserBo userBo) {
        UserEntity userEntity = entityBoMapper.userBoToEntity(userBo);
        userEntity = userRepository.save(userEntity);
        return entityBoMapper.userEntityToBo(userEntity);
    }

    @Override
    public UserBo checkUserUid(String userUid) {
        UserEntity userEntity = userRepository.findByUserUidAndStatus(userUid, MusicTrialConstant.ACTIVE);
        return entityBoMapper.userEntityToBo(userEntity);
    }

    @Override
    public UserBo checkEmailOrMobile(String email, String mobile) {
        UserEntity userEntity = userRepository.findFirstByEmailOrMobileAndStatus(email, mobile, MusicTrialConstant.ACTIVE);
        return entityBoMapper.userEntityToBo(userEntity);
    }

    @Override
    public UserBo login(String emailId, String password) {
        UserEntity userEntity = userRepository.findByEmailAndPasswordAndStatus(emailId, password,
                MusicTrialConstant.ACTIVE);
        if (Objects.isNull(userEntity)) {
            LOGGER.info("User Details don't exist or Password is Incorrect for uid: {}", emailId);
            throw new RuntimeException("User Details don't exist or Password is Incorrect");
        }
        return entityBoMapper.userEntityToBo(userEntity);
    }
}
