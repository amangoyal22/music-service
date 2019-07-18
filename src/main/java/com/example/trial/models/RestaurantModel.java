package com.example.trial.models;

import javax.persistence.*;

/**
 * The type Restaurant model.
 */
@MappedSuperclass
public class RestaurantModel {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Restaurant uid.
     */
    @Column(name = "owner_uid")
    private String ownerUid;

    /**
     * The Restaurant uid.
     */
    @Column(name = "restaurant_uid")
    private String restaurantUid;

    /**
     * The Restaurant name.
     */
    @Column(name = "restaurant_name")
    private String restaurantName;

    /**
     * The Restaurant location.
     */
    @Column(name = "restaurant_location")
    private String restaurantLocation;

    /**
     * The Restaurant logo.
     */
    @Column(name = "restaurant_logo")
    private String restaurantLogo;

    /**
     * The Status.
     */
    @Column(name = "status")
    byte status;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets restaurant uid.
     *
     * @return the restaurant uid
     */
    public String getRestaurantUid() {
        return restaurantUid;
    }

    /**
     * Sets restaurant uid.
     *
     * @param restaurantUid the restaurant uid
     */
    public void setRestaurantUid(String restaurantUid) {
        this.restaurantUid = restaurantUid;
    }

    /**
     * Gets restaurant name.
     *
     * @return the restaurant name
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Sets restaurant name.
     *
     * @param restaurantName the restaurant name
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Gets restaurant location.
     *
     * @return the restaurant location
     */
    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    /**
     * Sets restaurant location.
     *
     * @param restaurantLocation the restaurant location
     */
    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    /**
     * Gets restaurant logo.
     *
     * @return the restaurant logo
     */
    public String getRestaurantLogo() {
        return restaurantLogo;
    }

    /**
     * Sets restaurant logo.
     *
     * @param restaurantLogo the restaurant logo
     */
    public void setRestaurantLogo(String restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(byte status) {
        this.status = status;
    }
}
