package com.example.trial.models;

import javax.persistence.*;

/**
 * The type Owner model.
 */
@MappedSuperclass
public class OwnerModel {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * The Owner uid.
     */
    @Column(name = "owner_uid")
    String ownerUid;

    /**
     * The Name.
     */
    @Column(name = "name")
    String name;

    /**
     * The Password.
     */
    @Column(name = "password")
    String password;

    /**
     * The Mobile.
     */
    @Column(name = "mobile")
    String mobile;

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
     * Gets owner uid.
     *
     * @return the owner uid
     */
    public String getOwnerUid() {
        return ownerUid;
    }

    /**
     * Sets owner uid.
     *
     * @param ownerUid the owner uid
     */
    public void setOwnerUid(String ownerUid) {
        this.ownerUid = ownerUid;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets mobile.
     *
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets mobile.
     *
     * @param mobile the mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
