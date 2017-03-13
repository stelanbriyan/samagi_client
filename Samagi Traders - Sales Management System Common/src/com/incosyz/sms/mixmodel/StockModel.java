/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

import java.io.Serializable;

/**
 * Date : Oct 29, 2015 Time : 4:31:10 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class StockModel implements Serializable {

    private String modelId;
    private String batchId;
    private String modelName;
    private String BikeOption;
    private String capacity;
    private String commision;
    private String netAmount;
    private String roundNo;
    private String engineNo;
    private String stateName;
    private String isSold;
    private String remark;
    private String chassisNo;
    private String colour;

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     * @return 
     */
    public StockModel setModelId(String modelId) {
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
     * @return 
     */
    public StockModel setBatchId(String batchId) {
        this.batchId = batchId;
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
     * @return 
     */
    public StockModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    /**
     * @return the BikeOption
     */
    public String getBikeOption() {
        return BikeOption;
    }

    /**
     * @param BikeOption the BikeOption to set
     * @return 
     */
    public StockModel setBikeOption(String BikeOption) {
        this.BikeOption = BikeOption;
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
     * @return 
     */
    public StockModel setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * @return the commission
     */
    public String getCommision() {
        return commision;
    }

    /**
     * @param commision the commission to set
     * @return 
     */
    public StockModel setCommision(String commision) {
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
     * @return 
     */
    public StockModel setNetAmount(String netAmount) {
        this.netAmount = netAmount;
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
     * @return 
     */
    public StockModel setRoundNo(String roundNo) {
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
     * @return 
     */
    public StockModel setEngineNo(String engineNo) {
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
     * @return 
     */
    public StockModel setStateName(String stateName) {
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
     * @return 
     */
    public StockModel setIsSold(String isSold) {
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
     * @return 
     */
    public StockModel setRemark(String remark) {
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
     * @return 
     */
    public StockModel setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
        return this;
    }

    /**
     * @return the color
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the color to set
     * @return 
     */
    public StockModel setColour(String colour) {
        this.colour = colour;
        return this;
    }
}
