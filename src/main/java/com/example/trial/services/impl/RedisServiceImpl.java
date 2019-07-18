package com.example.trial.services.impl;

import com.example.trial.constant.RedisConstant;
import com.example.trial.services.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Redis service.
 */
@Service
public class RedisServiceImpl implements RedisService {

    /**
     * The Redis template.
     */
    @Autowired
    RedisTemplate<String, List> redisTemplate;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    @Override
    public void deleteSongKeys(Long songId) {
        LOGGER.info("Deleting Key For songId: {}", songId);
        redisTemplate.delete(songId + RedisConstant.REDIS_DISLIKE_SUFFIX);
        redisTemplate.delete(songId + RedisConstant.REDIS_LIKE_SUFFIX);
    }

    @Override
    public boolean checkUserLikeVote(String userUid, Long songId) {
        final String key = songId + RedisConstant.REDIS_LIKE_SUFFIX;
        if (redisTemplate.hasKey(key)) {
            LOGGER.info("Song like Key Contained for {}",songId);
            List<String> values = redisTemplate.opsForValue().get(key);
            return values.contains(userUid);
        }
        return false;
    }

    @Override
    public boolean checkUserUnlikeVote(String userUid, Long songId) {
        final String key = songId + RedisConstant.REDIS_DISLIKE_SUFFIX;
        if (redisTemplate.hasKey(key)) {
            LOGGER.info("Song Unlike Key Contained for {}",songId);
            List<String> values = redisTemplate.opsForValue().get(key);
            return values.contains(userUid);
        }
        return false;
    }


    @Override
    public void addUser(String userUid, Long songId, boolean vote) {
        String key;
        List<String> values;
        if(vote){
            key = songId + RedisConstant.REDIS_LIKE_SUFFIX;
        } else {
            key = songId + RedisConstant.REDIS_DISLIKE_SUFFIX;
        }


        if (redisTemplate.hasKey(key)) {
            LOGGER.info("Song like Key Contained for {}",songId);
            values = redisTemplate.opsForValue().get(key);
            values.add(userUid);
        } else {
            LOGGER.info("Song like Key created for {}",songId);
            values = new ArrayList<>();
            values.add(userUid);
        }
        redisTemplate.opsForValue().set(key,values);
    }

    @Override
    public void deleteUser(String userUid, Long songId, boolean vote) {
        String key;
        List<String> values;
        if(vote){
            key = songId + RedisConstant.REDIS_LIKE_SUFFIX;
        } else {
            key = songId + RedisConstant.REDIS_DISLIKE_SUFFIX;
        }
        if (redisTemplate.hasKey(key)) {
            LOGGER.info("Song like Key Contained for {}",songId);
            values = redisTemplate.opsForValue().get(key);
            values.remove(userUid);
            redisTemplate.opsForValue().set(key,values);
        }
    }
}