/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 *
 * @author Stelan
 */
public class BikeModel implements Serializable{

    private String bikeModelId;
    private String modelId;
    private String priceAnnouncementId;
    private String modelName;
    private String bikeOption;
    private String capacity;
    private String commision;
    private String netAmount;
    private String note;
    private String helmet;
    private String jacket;

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public BikeModel setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * @return the priceAnnouncementId
     */
    public String getPriceAnnouncementId() {
        return priceAnnouncementId;
    }

    /**
     * @param priceAnnouncementId the priceAnnouncementId to set
     */
    public BikeModel setPriceAnnouncementId(String priceAnnouncementId) {
        this.priceAnnouncementId = priceAnnouncementId;
        return this;
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
    public BikeModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    /**
     * @return the bikeOption
     */
    public String getBikeOption() {
        return bikeOption;
    }

    /**
     * @param bikeOption the bikeOption to set
     */
    public BikeModel setBikeOption(String bikeOption) {
        this.bikeOption = bikeOption;
        return this;
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
    public BikeModel setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * @return the commision
     */
    public String getCommision() {
        return commision;
    }

    /**
     * @param commision the commision to set
     */
    public BikeModel setCommision(String commision) {
        this.commision = commision;
        return this;
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
    public BikeModel setNetAmount(String netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public BikeModel setNote(String note) {
        this.note = note;
        return this;
    }

    /**
     * @return the helmet
     */
    public String getHelmet() {
        return helmet;
    }

    /**
     * @param helmet the helmet to set
     */
    public BikeModel setHelmet(String helmet) {
        this.helmet = helmet;
        return this;
    }

    /**
     * @return the jacket
     */
    public String getJacket() {
        return jacket;
    }

    /**
     * @param jacket the jacket to set
     */
    public BikeModel setJacket(String jacket) {
        this.jacket = jacket;
        return this;        
    }

    /**
     * @return the bikeModelId
     */
    public String getBikeModelId() {
        return bikeModelId;
    }

    /**
     * @param bikeModelId the bikeModelId to set
     */
    public BikeModel setBikeModelId(String bikeModelId) {
        this.bikeModelId = bikeModelId;
        return this;
    }
}
