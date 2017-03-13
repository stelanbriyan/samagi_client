/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Stelan Briyan
 */
public class CRNPlateInfo implements Serializable{
    private boolean cr;
    private boolean nPlate;
    private Date crR;
    private Date crI;
    private Date nPlateR;
    private Date nPlateI;
    private String orderId;
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

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    
}
