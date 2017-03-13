/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015 Time : 5:43:35 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class RmvModel implements Serializable {
    private String rmvId;
    private String mta3;
    private String doNo;
    private String idCopy;
    private String idPhotos;
    private String isLeasing;

    /**
     * @return the rmvId
     */
    public String getRmvId() {
        return rmvId;
    }

    /**
     * @param rmvId the rmvId to set
     */
    public RmvModel setRmvId(String rmvId) {
        this.rmvId = rmvId;
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
    public RmvModel setMta3(String mta3) {
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
    public RmvModel setDoNo(String doNo) {
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
    public RmvModel setIdCopy(String idCopy) {
        this.idCopy = idCopy;
        return this;
    }

    /**
     * @return the idPhotos
     */
    public String getIdPhotos() {
        return idPhotos;
    }

    /**
     * @param idPhotos the idPhotos to set
     */
    public RmvModel setIdPhotos(String idPhotos) {
        this.idPhotos = idPhotos;
        return this;
    }

    /**
     * @return the isLeasing
     */
    public String getIsLeasing() {
        return isLeasing;
    }

    /**
     * @param isLeasing the isLeasing to set
     */
    public RmvModel setIsLeasing(String isLeasing) {
        this.isLeasing = isLeasing;
        return this;
    }
}
