/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Oct 27, 2015 Time : 9:30:54 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SpecialDealerModel implements Serializable{

    private String specialDealerId;
    private String modelId;
    private String specialPrice;
    private String dealerMargine;

    /**
     * @return the specialDealerId
     */
    public String getSpecialDealerId() {
        return specialDealerId;
    }

    /**
     * @param specialDealerId the specialDealerId to set
     */
    public SpecialDealerModel setSpecialDealerId(String specialDealerId) {
        this.specialDealerId = specialDealerId;
        return this;
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
    public SpecialDealerModel setModelId(String modelId) {
        this.modelId = modelId;
        return this;
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
    public SpecialDealerModel setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
        return this;
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
    public SpecialDealerModel setDealerMargine(String dealerMargine) {
        this.dealerMargine = dealerMargine;
        return this;
    }
}
