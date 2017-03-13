/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015 Time : 5:57:10 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UserModel implements Serializable {

    private String userId;
    private String userName;
    private String password;
    private String userType;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public UserModel setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public UserModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public UserModel setUserType(String userType) {
        this.userType = userType;
        return this;
    }
}
