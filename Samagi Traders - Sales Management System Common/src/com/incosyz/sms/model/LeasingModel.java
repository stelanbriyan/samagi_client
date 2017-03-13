/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015 Time : 1:51:24 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class LeasingModel implements Serializable {

    private String leasingId;
    private String paymentId;
    private String leasingAmount;
    private String mta;
    private String mta2;
    private String mta3;
    private String doNo;
    private String doNo2;
    private String idCopy;
    private String gs;
    private String gap;
    private String garanter;
    private String leasingName;
    private String idPhoto;
    private String snCharge;

    /**
     * @return the leasingId
     */
    public String getLeasingId() {
        return leasingId;
    }

    /**
     * @param leasingId the leasingId to set
     */
    public LeasingModel setLeasingId(String leasingId) {
        this.leasingId = leasingId;
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
    public LeasingModel setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * @return the leasingAmount
     */
    public String getLeasingAmount() {
        return leasingAmount;
    }

    /**
     * @param leasingAmount the leasingAmount to set
     */
    public LeasingModel setLeasingAmount(String leasingAmount) {
        this.leasingAmount = leasingAmount;
        return this;
    }

    /**
     * @return the mta
     */
    public String getMta() {
        return mta;
    }

    /**
     * @param mta the mta to set
     */
    public LeasingModel setMta(String mta) {
        this.mta = mta;
        return this;
    }

    /**
     * @return the mta2
     */
    public String getMta2() {
        return mta2;
    }

    /**
     * @param mta2 the mta2 to set
     */
    public LeasingModel setMta2(String mta2) {
        this.mta2 = mta2;
        return this;
    }

    /**
     * @return the mta3
     */
    public String getMta3() {
        return mta3;
    }

    /**
     * @param mta3 the mta3 to set
     */
    public LeasingModel setMta3(String mta3) {
        this.mta3 = mta3;
        return this;
    }

    /**
     * @return the doNo
     */
    public String getDoNo() {
        return doNo;
    }

    /**
     * @param doNo the doNo to set
     */
    public LeasingModel setDoNo(String doNo) {
        this.doNo = doNo;
        return this;
    }

    /**
     * @return the idCopy
     */
    public String getIdCopy() {
        return idCopy;
    }

    /**
     * @param idCopy the idCopy to set
     */
    public LeasingModel setIdCopy(String idCopy) {
        this.idCopy = idCopy;
        return this;
    }

    /**
     * @return the gs
     */
    public String getGs() {
        return gs;
    }

    /**
     * @param gs the gs to set
     */
    public LeasingModel setGs(String gs) {
        this.gs = gs;
        return this;
    }

    /**
     * @return the gap
     */
    public String getGap() {
        return gap;
    }

    /**
     * @param gap the gap to set
     */
    public LeasingModel setGap(String gap) {
        this.gap = gap;
        return this;
    }

    /**
     * @return the garanter
     */
    public String getGaranter() {
        return garanter;
    }

    /**
     * @param garanter the garanter to set
     */
    public LeasingModel setGaranter(String garanter) {
        this.garanter = garanter;
        return this;
    }

    /**
     * @return the doNo2
     */
    public String getDoNo2() {
        return doNo2;
    }

    /**
     * @param doNo2 the doNo2 to set
     */
    public LeasingModel setDoNo2(String doNo2) {
        this.doNo2 = doNo2;
        return this;
    }

    /**
     * @return the leasingName
     */
    public String getLeasingName() {
        return leasingName;
    }

    /**
     * @param leasingName the leasingName to set
     */
    public LeasingModel setLeasingName(String leasingName) {
        this.leasingName = leasingName;
        return this;
    }

    /**
     * @return the idPhoto
     */
    public String getIdPhoto() {
        return idPhoto;
    }

    /**
     * @param idPhoto the idPhoto to set
     */
    public LeasingModel setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto;
        return this;
    }

    /**
     * @return the snCharge
     */
    public String getSnCharge() {
        return snCharge;
    }

    /**
     * @param snCharge the snCharge to set
     */
    public LeasingModel setSnCharge(String snCharge) {
        this.snCharge = snCharge;
        return this;
    }
}
