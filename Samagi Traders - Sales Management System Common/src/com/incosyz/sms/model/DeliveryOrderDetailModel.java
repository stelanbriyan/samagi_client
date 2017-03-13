/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Oct 28, 2015 Time : 9:47:20 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class DeliveryOrderDetailModel implements Serializable{
    private String priceAnnouncementId;
    private String modelId;
    private String modelName ;
    private String batchId;
    private String roundNo;
    private String engineNo;
    private String stateName;
    private String isSold;
    private String remark;
    private String chassisNo;
    private String note;
    private String colour;

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public DeliveryOrderDetailModel setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public DeliveryOrderDetailModel setBatchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    /**
     * @return the roundNo
     */
    public String getRoundNo() {
        return roundNo;
    }

    /**
     * @param roundNo the roundNo to set
     */
    public DeliveryOrderDetailModel setRoundNo(String roundNo) {
        this.roundNo = roundNo;
        return this;
    }

    /**
     * @return the engineNo
     */
    public String getEngineNo() {
        return engineNo;
    }

    /**
     * @param engineNo the engineNo to set
     */
    public DeliveryOrderDetailModel setEngineNo(String engineNo) {
        this.engineNo = engineNo;
        return this;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public DeliveryOrderDetailModel setStateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    /**
     * @return the isSold
     */
    public String getIsSold() {
        return isSold;
    }

    /**
     * @param isSold the isSold to set
     */
    public DeliveryOrderDetailModel setIsSold(String isSold) {
        this.isSold = isSold;
        return this;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public DeliveryOrderDetailModel setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    /**
     * @return the chassisNo
     */
    public String getChassisNo() {
        return chassisNo;
    }

    /**
     * @param chassisNo the chassisNo to set
     */
    public DeliveryOrderDetailModel setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
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
     * @return 
     */
    public DeliveryOrderDetailModel setNote(String note) {
        this.note = note;
        return this;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     * @return 
     */
    public DeliveryOrderDetailModel setColour(String colour) {
        this.colour = colour;
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
    public DeliveryOrderDetailModel setModelName(String modelName) {
        this.modelName = modelName;
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
     * @return 
     */
    public DeliveryOrderDetailModel setPriceAnnouncementId(String priceAnnouncementId) {
        this.priceAnnouncementId = priceAnnouncementId;
        return this;
    }
}
