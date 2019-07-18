package com.example.trial.services;

/**
 * The interface Redis service.
 */
public interface RedisService {
    /**
     * Delete song key.
     *
     * @param songId the song id
     */
    void deleteSongKeys(Long songId);

    /**
     * Check user like vote boolean.
     *
     * @param userUid the user uid
     * @param songId  the song id
     * @return the boolean
     */
    boolean checkUserLikeVote(String userUid, Long songId);

    /**
     * Check user unlike vote boolean.
     *
     * @param userUid the user uid
     * @param songId  the song id
     * @return the boolean
     */
    boolean checkUserUnlikeVote(String userUid, Long songId);

    /**
     * Add user.
     *
     * @param userUid the user uid
     * @param songId  the song id
     * @param vote    the vote
     */
    void addUser(String userUid, Long songId,boolean vote);

    /**
     * Delete user.
     *
     * @param userUid the user uid
     * @param songId  the song id
     * @param vote    the vote
     */
    void deleteUser(String userUid, Long songId,boolean vote);
}
