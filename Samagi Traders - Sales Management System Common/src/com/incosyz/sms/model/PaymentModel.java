/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015 Time : 4:50:46 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class PaymentModel implements Serializable{

    private String paymentId;
    private String commision;
    private String orderAmount;
    private String bikeAmount;
    private String rmvAmount;
    private String insuranceAmount;
    private String otherPaymentAmount;
    private String note;

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public PaymentModel setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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
    public PaymentModel setCommision(String commision) {
        this.commision = commision;
        return this;
    }

    /**
     * @return the orderAmount
     */
    public String getOrderAmount() {
        return orderAmount;
    }

    /**
     * @param orderAmount the orderAmount to set
     */
    public PaymentModel setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    /**
     * @return the otherPaymentAmount
     */
    public String getOtherPaymentAmount() {
        return otherPaymentAmount;
    }

    /**
     * @param otherPaymentAmount the otherPaymentAmount to set
     */
    public PaymentModel setOtherPaymentAmount(String otherPaymentAmount) {
        this.otherPaymentAmount = otherPaymentAmount;
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
    public PaymentModel setNote(String note) {
        this.note = note;
        return this;
    }

    /**
     * @return the bikeAmount
     */
    public String getBikeAmount() {
        return bikeAmount;
    }

    /**
     * @return the rmvAmount
     */
    public String getRmvAmount() {
        return rmvAmount;
    }

    /**
     * @return the insuranceAmount
     */
    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    /**
     * @param bikeAmount the bikeAmount to set
     */
    public PaymentModel setBikeAmount(String bikeAmount) {
        this.bikeAmount = bikeAmount;
        return this;
    }

    /**
     * @param rmvAmount the rmvAmount to set
     */
    public PaymentModel setRmvAmount(String rmvAmount) {
        this.rmvAmount = rmvAmount;
        return this;
    }

    /**
     * @param insuranceAmount the insuranceAmount to set
     */
    public PaymentModel setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
        return this;
    }
}
