/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

import java.io.Serializable;

/**
 * Date : Oct 27, 2015 Time : 10:44:04 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class BikeSpecialDealerModel implements Serializable{

    private String priceAnnouncementId;
    private String specialDealerId;
    private String modelId;
    private String netAmount;
    private String specialPrice;
    private String dealerMargine;
    private String modelName;
    private String capacity;

    /**
     * @return the priceAnnouncementId
     */
    public String getPriceAnnouncementId() {
        return priceAnnouncementId;
    }

    /**
     * @param priceAnnouncementId the priceAnnouncementId to set
     */
    public void setPriceAnnouncementId(String priceAnnouncementId) {
        this.priceAnnouncementId = priceAnnouncementId;
    }

    /**
     * @return the specialDealerId
     */
    public String getSpecialDealerId() {
        return specialDealerId;
    }

    /**
     * @param specialDealerId the specialDealerId to set
     */
    public void setSpecialDealerId(String specialDealerId) {
        this.specialDealerId = specialDealerId;
    }

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * @return the specialPrice
     */
    public String getSpecialPrice() {
        return specialPrice;
    }

    /**
     * @param specialPrice the specialPrice to set
     */
    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    /**
     * @return the dealerMargine
     */
    public String getDealerMargine() {
        return dealerMargine;
    }

    /**
     * @param dealerMargine the dealerMargine to set
     */
    public void setDealerMargine(String dealerMargine) {
        this.dealerMargine = dealerMargine;
    }

    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the netAmount
     */
    public String getNetAmount() {
        return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }
}
