/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 23, 2015 Time : 12:47:49 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ReturnModel implements Serializable {

    private String returnId;
    private String roundNo;
    private String note;
    private String date;

    /**
     * @return the returnId
     */
    public String getReturnId() {
        return returnId;
    }

    /**
     * @param returnId the returnId to set
     */
    public ReturnModel setReturnId(String returnId) {
        this.returnId = returnId;
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
    public ReturnModel setRoundNo(String roundNo) {
        this.roundNo = roundNo;
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
    public ReturnModel setNote(String note) {
        this.note = note;
        return this;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public ReturnModel setDate(String date) {
        this.date = date;
        return this;
    }
}
