/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Nov 6, 2015 Time : 1:34:31 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CheckModel implements Serializable {

    private String chequeId;
    private String paymentId;
    private String checkNo;
    private String bankName;
    private String chequeDate;
    private String amount;
    private String stateName;
    private String issuedBy;
    private String type;
    private String accountNo;
    private String note;
    private String isIssued;

    /**
     * @return the chequeId
     */
    public String getChequeId() {
        return chequeId;
    }

    /**
     * @param chequeId the chequeId to set
     * @return
     */
    public CheckModel setChequeId(String chequeId) {
        this.chequeId = chequeId;
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
     * @return
     */
    public CheckModel setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * @return the checkNo
     */
    public String getCheckNo() {
        return checkNo;
    }

    /**
     * @param checkNo the checkNo to set
     * @return
     */
    public CheckModel setCheckNo(String checkNo) {
        this.checkNo = checkNo;
        return this;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     * @return
     */
    public CheckModel setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    /**
     * @return the chequeDate
     */
    public String getChequeDate() {
        return chequeDate;
    }

    /**
     * @param chequeDate the chequeDate to set
     * @return
     */
    public CheckModel setChequeDate(String chequeDate) {
        this.chequeDate = chequeDate;
        return this;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     * @return
     */
    public CheckModel setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     * @return
     */
    public CheckModel setStateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    /**
     * @return the issuedBy
     */
    public String getIssuedBy() {
        return issuedBy;
    }

    /**
     * @param issuedBy the issuedBy to set
     */
    public CheckModel setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
        return this;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public CheckModel setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public CheckModel setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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
    public CheckModel setNote(String note) {
        this.note = note;
        return this;
    }

    /**
     * @return the isIssued
     */
    public String getIsIssued() {
        return isIssued;
    }

    /**
     * @param isIssued the isIssued to set
     */
    public CheckModel setIsIssued(String isIssued) {
        this.isIssued = isIssued;
        return this;
    }
}
