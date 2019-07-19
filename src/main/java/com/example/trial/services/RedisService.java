package com.example.trial.services;

/**
 * The interface Redis service.
 */
public interface RedisService {
    /**
     * Delete song key.
     *
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     */
    void deleteSongKeys(Long songId,String restaurantUid);

    /**
     * Check user like vote boolean.
     *
     * @param userUid       the user uid
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     * @return the boolean
     */
    boolean checkUserLikeVote(String userUid, Long songId,String restaurantUid);

    /**
     * Check user unlike vote boolean.
     *
     * @param userUid       the user uid
     * @param songId        the song id
     * @param restaurantUid the restaurant uid
     * @return the boolean
     */
    boolean checkUserUnlikeVote(String userUid, Long songId,String restaurantUid);

    /**
     * Add user.
     *
     * @param userUid       the user uid
     * @param restaurantUid the restaurant uid
     * @param songId        the song id
     * @param vote          the vote
     */
    void addUser(String userUid,String restaurantUid, Long songId,boolean vote);

    /**
     * Delete user.
     *
     * @param userUid       the user uid
     * @param restaurantUid the restaurant uid
     * @param songId        the song id
     * @param vote          the vote
     */
    void deleteUser(String userUid,String restaurantUid,Long songId,boolean vote);
}
