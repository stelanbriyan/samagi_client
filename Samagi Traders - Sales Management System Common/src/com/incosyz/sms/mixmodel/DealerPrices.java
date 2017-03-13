/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

/**
 * Date : Nov 3, 2015 Time : 10:56:03 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class DealerPrices {

    private String commision;
    private String bikeAmount;
    private String netRemittance;
    private String valueNote;
    private String otherPayment;
    private String rmvRegistration;
    private String insurance;

    /**
     * @return the commision
     */
    public String getCommision() {
        return commision;
    }

    /**
     * @param commision the commision to set
     */
    public DealerPrices setCommision(String commision) {
        this.commision = commision;
        return this;
    }

    /**
     * @return the bikeAmount
     */
    public String getBikeAmount() {
        return bikeAmount;
    }

    /**
     * @param bikeAmount the bikeAmount to set
     */
    public DealerPrices setBikeAmount(String bikeAmount) {
        this.bikeAmount = bikeAmount;
        return this;
    }

    /**
     * @return the netRemittance
     */
    public String getNetRemittance() {
        return netRemittance;
    }

    /**
     * @param netRemittance the netRemittance to set
     */
    public DealerPrices setNetRemittance(String netRemittance) {
        this.netRemittance = netRemittance;
        return this;
    }

    /**
     * @return the valueNote
     */
    public String getValueNote() {
        return valueNote;
    }

    /**
     * @param valueNote the valueNote to set
     */
    public DealerPrices setValueNote(String valueNote) {
        this.valueNote = valueNote;
        return this;
    }

    /**
     * @return the otherPayment
     */
    public String getOtherPayment() {
        return otherPayment;
    }

    /**
     * @param otherPayment the otherPayment to set
     */
    public void setOtherPayment(String otherPayment) {
        this.otherPayment = otherPayment;
    }

    /**
     * @return the rmvRegistration
     */
    public String getRmvRegistration() {
        return rmvRegistration;
    }

    /**
     * @param rmvRegistration the rmvRegistration to set
     */
    public DealerPrices setRmvRegistration(String rmvRegistration) {
        this.rmvRegistration = rmvRegistration;
        return this;
    }

    /**
     * @return the insurance
     */
    public String getInsurance() {
        return insurance;
    }

    /**
     * @param insurance the insurance to set
     */
    public DealerPrices setInsurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

}
