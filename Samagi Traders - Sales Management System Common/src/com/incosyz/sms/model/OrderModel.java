/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Date : Nov 6, 2015 Time : 5:19:07 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderModel implements Serializable {

    private String orderId;
    private String roundNo;
    private String bikeModelId;
    private String customerId;
    private String rmvId;
    private String userId;
    private String paymentId;
    private String orderTime;
    private String orderDate;
    private String note;
    private String orderAmount;
    private String rmv;
    private String insurance;
    
    private boolean cr;
    private boolean nPlate;
    private Date crR;
    private Date crI;
    private Date nPlateR;
    private Date nPlateI;
    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public OrderModel setOrderId(String orderId) {
        this.orderId = orderId;
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
    public OrderModel setRoundNo(String roundNo) {
        this.roundNo = roundNo;
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
    public OrderModel setBikeModelId(String bikeModelId) {
        this.bikeModelId = bikeModelId;
        return this;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public OrderModel setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * @return the rmvId
     */
    public String getRmvId() {
        return rmvId;
    }

    /**
     * @param rmvId the rmvId to set
     */
    public OrderModel setRmvId(String rmvId) {
        this.rmvId = rmvId;
        return this;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public OrderModel setUserId(String userId) {
        this.userId = userId;
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
    public OrderModel setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * @return the orderTime
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime the orderTime to set
     */
    public OrderModel setOrderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public OrderModel setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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
    public OrderModel setNote(String note) {
        this.note = note;
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
    public OrderModel setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    /**
     * @return the rmv
     */
    public String getRmv() {
        return rmv;
    }

    /**
     * @param rmv the rmv to set
     */
    public OrderModel setRmv(String rmv) {
        this.rmv = rmv;
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
    public OrderModel setInsurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

    /**
     * @return the cr
     */
    public boolean isCr() {
        return cr;
    }

    /**
     * @param cr the cr to set
     */
    public void setCr(boolean cr) {
        this.cr = cr;
    }

    /**
     * @return the nPlate
     */
    public boolean isnPlate() {
        return nPlate;
    }

    /**
     * @param nPlate the nPlate to set
     */
    public void setnPlate(boolean nPlate) {
        this.nPlate = nPlate;
    }

    /**
     * @return the crR
     */
    public Date getCrR() {
        return crR;
    }

    /**
     * @param crR the crR to set
     */
    public void setCrR(Date crR) {
        this.crR = crR;
    }

    /**
     * @return the crI
     */
    public Date getCrI() {
        return crI;
    }

    /**
     * @param crI the crI to set
     */
    public void setCrI(Date crI) {
        this.crI = crI;
    }

    /**
     * @return the nPlateR
     */
    public Date getnPlateR() {
        return nPlateR;
    }

    /**
     * @param nPlateR the nPlateR to set
     */
    public void setnPlateR(Date nPlateR) {
        this.nPlateR = nPlateR;
    }

    /**
     * @return the nPlateI
     */
    public Date getnPlateI() {
        return nPlateI;
    }

    /**
     * @param nPlateI the nPlateI to set
     */
    public void setnPlateI(Date nPlateI) {
        this.nPlateI = nPlateI;
    }
    
    
}
