/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 4, 2015 Time : 3:07:26 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
    public class MobileModel implements Serializable{

    private String mobileId;
    private String customerId;
    private String mobileNo;

    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public MobileModel setMobileId(String mobileId) {
        this.mobileId = mobileId;
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
     */
    public MobileModel setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public MobileModel setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }
}
