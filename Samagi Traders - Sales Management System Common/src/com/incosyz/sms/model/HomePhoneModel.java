/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 4, 2015 Time : 3:08:35 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class HomePhoneModel implements Serializable {

    private String homePhoneId;
    private String customerId;
    private String homePhoneNo;

    /**
     * @return the homePhoneId
     */
    public String getHomePhoneId() {
        return homePhoneId;
    }

    /**
     * @param homePhoneId the homePhoneId to set
     * @return 
     */
    public HomePhoneModel setHomePhoneId(String homePhoneId) {
        this.homePhoneId = homePhoneId;
        return this;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     * @return 
     */
    public HomePhoneModel setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * @return the homePhoneNo
     */
    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    /**
     * @param homePhoneNo the homePhoneNo to set
     * @return 
     */
    public HomePhoneModel setHomePhoneNo(String homePhoneNo) {
        this.homePhoneNo = homePhoneNo;
        return this;
    }
}
