package com.example.trial.models;

import javax.persistence.*;

/**
 * The type Test.
 */
/*
 * Created by Aman Goyal on 2019-07-12. Don't mess with this!
 */
@MappedSuperclass
public class UserModel {
    /**
     * The Id.
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * The User uid.
     */
    @Column(name = "user_uid")
    String userUid;
    /**
     * The Name.
     */
    @Column(name = "name")
    String name;
    /**
     * The Email.
     */
    @Column(name = "email")
    String email;
    /**
     * The Mobile.
     */
    @Column(name = "mobile")
    String mobile;
    /**
     * The Password.
     */
    @Column(name = "password")
    String password;
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
     * Gets user uid.
     *
     * @return the user uid
     */
    public String getUserUid() {
        return userUid;
    }

    /**
     * Sets user uid.
     *
     * @param userUid the user uid
     */
    public void setUserUid(String userUid) {
        this.userUid = userUid;
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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
