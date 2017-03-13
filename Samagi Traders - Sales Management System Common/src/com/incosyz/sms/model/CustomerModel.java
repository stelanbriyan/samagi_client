/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 4, 2015 Time : 3:03:23 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CustomerModel implements Serializable {

    private String customerId;
    private String customerName;
    private String nicNo;
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public CustomerModel setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public CustomerModel setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * @return the nicNo
     */
    public String getNicNo() {
        return nicNo;
    }

    /**
     * @param nicNo the nicNo to set
     */
    public CustomerModel setNicNo(String nicNo) {
        this.nicNo = nicNo;
        return this;
    }

    /**
     * @return the addressLineOne
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * @param addressLineOne the addressLineOne to set
     */
    public CustomerModel setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    /**
     * @return the addressLineTwo
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * @param addressLineTwo the addressLineTwo to set
     */
    public CustomerModel setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        return this;
    }

    /**
     * @return the addressLineThree
     */
    public String getAddressLineThree() {
        return addressLineThree;
    }

    /**
     * @param addressLineThree the addressLineThree to set
     */
    public CustomerModel setAddressLineThree(String addressLineThree) {
        this.addressLineThree = addressLineThree;
        return this;
    }
}
