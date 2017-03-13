/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

import java.io.Serializable;

/**
 * Date : Nov 21, 2015 Time : 9:37:39 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UserOrderModel implements Serializable{
    private String userId;
    private String userName;
    private String userType;
    private String orderCount;
    private String orderDate;
    private String saleAmount;
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public UserOrderModel setUserName(String userName) {
        this.userName = userName;
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
    public UserOrderModel setUserType(String userType) {
        this.userType = userType;
        return this;
    }

    /**
     * @return the orderCount
     */
    public String getOrderCount() {
        return orderCount;
    }

    /**
     * @param orderCount the orderCount to set
     */
    public UserOrderModel setOrderCount(String orderCount) {
        this.orderCount = orderCount;
        return this;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public UserOrderModel setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public UserOrderModel setUserId(String userId) {
        this.userId = userId;
        return this; 
    }

    /**
     * @return the saleAmount
     */
    public String getSaleAmount() {
        return saleAmount;
    }

    /**
     * @param saleAmount the saleAmount to set
     */
    public UserOrderModel setSaleAmount(String saleAmount) {
        this.saleAmount = saleAmount;
        return this;
    }
}
