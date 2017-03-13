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
public class PriceAnnouncementModel implements Serializable {

    private String priceAnnouncementId;
    private String priceAnnouncementDate;
    private String effectDate;
    private String description;

    /**
     * @return the priceAnnouncementDate
     */
    public String getPriceAnnouncementDate() {
        return priceAnnouncementDate;
    }

    /**
     * @param priceAnnouncementDate the priceAnnouncementDate to set
     */
    public PriceAnnouncementModel setPriceAnnouncementDate(String priceAnnouncementDate) {
        this.priceAnnouncementDate = priceAnnouncementDate;
        return this;
    }

    /**
     * @return the effectDate
     */
    public String getEffectDate() {
        return effectDate;
    }

    /**
     * @param effectDate the effectDate to set
     */
    public PriceAnnouncementModel setEffectDate(String effectDate) {
        this.effectDate = effectDate;
        return this;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public PriceAnnouncementModel setDescription(String description) {
        this.description = description;
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
    public PriceAnnouncementModel setPriceAnnouncementId(String priceAnnouncementId) {
        this.priceAnnouncementId = priceAnnouncementId;
        return this;
    }
}
