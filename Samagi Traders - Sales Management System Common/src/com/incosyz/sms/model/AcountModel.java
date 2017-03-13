/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 19, 2015
 * Time : 8:34:48 PM
 * @copyright INCOSYZ
 * @author Stelan
 */
public class AcountModel implements Serializable{
    private String acountId;
    private String date;
    private String description;
    private String income;
    private String expenditure;

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public AcountModel setDate(String date) {
        this.date = date;
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
    public AcountModel setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * @return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public AcountModel setIncome(String income) {
        this.income = income;
        return this;
    }

    /**
     * @return the expenditure
     */
    public String getExpenditure() {
        return expenditure;
    }

    /**
     * @param expenditure the expenditure to set
     */
    public AcountModel setExpenditure(String expenditure) {
        this.expenditure = expenditure;
        return this;
    }

    /**
     * @return the acountId
     */
    public String getAcountId() {
        return acountId;
    }

    /**
     * @param acountId the acountId to set
     */
    public AcountModel setAcountId(String acountId) {
        this.acountId = acountId;
        return this;
    }
}
