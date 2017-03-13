/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015
 * Time : 1:22:00 PM
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CashModel implements Serializable{
    private String cashId ;
    private String paymentId;
    private String cashAmount;
    private String cashDate;

    /**
     * @return the cashId
     */
    public String getCashId() {
        return cashId;
    }

    /**
     * @param cashId the cashId to set
     */
    public CashModel setCashId(String cashId) {
        this.cashId = cashId;
        return this;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public CashModel setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * @return the cashAmount
     */
    public String getCashAmount() {
        return cashAmount;
    }

    /**
     * @param cashAmount the cashAmount to set
     */
    public CashModel setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
        return this;
    }

    /**
     * @return the cashDate
     */
    public String getCashDate() {
        return cashDate;
    }

    /**
     * @param cashDate the cashDate to set
     */
    public CashModel setCashDate(String cashDate) {
        this.cashDate = cashDate;
        return this;
    }
    
    
}
