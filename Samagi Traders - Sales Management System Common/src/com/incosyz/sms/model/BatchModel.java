/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Oct 28, 2015 Time : 11:02:59 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class BatchModel implements Serializable {

    private String batchId;
    private String consignmentNoteNo;
    private String orderRequestNo;
    private String transportInvoiceNo;
    private String batchDate;
    private String transportOrderNo;
    private String note;
    private String userId;
    private String helmet;
    private String warrantyManual;
    private String sideMirror;
    private String jacket;
    private String toolKit;
    private String manual;
    private String contactNo;
    private String vehicleNo;
    private String driverName;
    private String helperName;
    private String count ;
    
    public BatchModel() {
    }

    public BatchModel(String batchId, String consignmentNoteNo, String orderRequestNo, String transportInvoiceNo, String batchDate, String transportOrderNo, String note, String userId, String helmet, String warrantyManual, String sideMirror, String jacket, String toolKit, String manual, String contactNo, String vehicleNo, String driverName, String helperName) {
        this.batchId = batchId;
        this.consignmentNoteNo = consignmentNoteNo;
        this.orderRequestNo = orderRequestNo;
        this.transportInvoiceNo = transportInvoiceNo;
        this.batchDate = batchDate;
        this.transportOrderNo = transportOrderNo;
        this.note = note;
        this.userId = userId;
        this.helmet = helmet;
        this.warrantyManual = warrantyManual;
        this.sideMirror = sideMirror;
        this.jacket = jacket;
        this.toolKit = toolKit;
        this.manual = manual;
        this.contactNo = contactNo;
        this.vehicleNo = vehicleNo;
        this.driverName = driverName;
        this.helperName = helperName;
    }

    
    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public BatchModel setBatchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    /**
     * @return the consignmentNoteNo
     */
    public String getConsignmentNoteNo() {
        return consignmentNoteNo;
    }

    /**
     * @param consignmentNoteNo the consignmentNoteNo to set
     */
    public BatchModel setConsignmentNoteNo(String consignmentNoteNo) {
        this.consignmentNoteNo = consignmentNoteNo;
        return this;
    }

    /**
     * @return the orderRequestNo
     */
    public String getOrderRequestNo() {
        return orderRequestNo;
    }

    /**
     * @param orderRequestNo the orderRequestNo to set
     */
    public BatchModel setOrderRequestNo(String orderRequestNo) {
        this.orderRequestNo = orderRequestNo;
        return this;
    }

    /**
     * @return the transportInvoiceNo
     */
    public String getTransportInvoiceNo() {
        return transportInvoiceNo;
    }

    /**
     * @param transportInvoiceNo the transportInvoiceNo to set
     */
    public BatchModel setTransportInvoiceNo(String transportInvoiceNo) {
        this.transportInvoiceNo = transportInvoiceNo;
        return this;
    }

    /**
     * @return the batchDate
     */
    public String getBatchDate() {
        return batchDate;
    }

    /**
     * @param batchDate the batchDate to set
     */
    public BatchModel setBatchDate(String batchDate) {
        this.batchDate = batchDate;
        return this;
    }

    /**
     * @return the transportOrderNo
     */
    public String getTransportOrderNo() {
        return transportOrderNo;
    }

    /**
     * @param transportOrderNo the transportOrderNo to set
     */
    public BatchModel setTransportOrderNo(String transportOrderNo) {
        this.transportOrderNo = transportOrderNo;
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
    public BatchModel setNote(String note) {
        this.note = note;
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
    public BatchModel setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * @return the helmet
     */
    public String getHelmet() {
        return helmet;
    }

    /**
     * @param helmet the helmet to set
     */
    public BatchModel setHelmet(String helmet) {
        this.helmet = helmet;
        return this;
    }

    /**
     * @return the warrantyManual
     */
    public String getWarrantyManual() {
        return warrantyManual;
    }

    /**
     * @param warrantyManual the warrantyManual to set
     */
    public BatchModel setWarrantyManual(String warrantyManual) {
        this.warrantyManual = warrantyManual;
        return this;
    }

    /**
     * @return the sideMirror
     */
    public String getSideMirror() {
        return sideMirror;
    }

    /**
     * @param sideMirror the sideMirror to set
     */
    public BatchModel setSideMirror(String sideMirror) {
        this.sideMirror = sideMirror;
        return this;
    }

    /**
     * @return the jacket
     */
    public String getJacket() {
        return jacket;
    }

    /**
     * @param jacket the jacket to set
     */
    public BatchModel setJacket(String jacket) {
        this.jacket = jacket;
        return this;
    }

    /**
     * @return the toolKit
     */
    public String getToolKit() {
        return toolKit;
    }

    /**
     * @param toolKit the toolKit to set
     */
    public BatchModel setToolKit(String toolKit) {
        this.toolKit = toolKit;
        return this;
    }

    /**
     * @return the manual
     */
    public String getManual() {
        return manual;
    }

    /**
     * @param manual the manual to set
     */
    public BatchModel setManual(String manual) {
        this.manual = manual;
        return this;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public BatchModel setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    /**
     * @return the vehicleNo
     */
    public String getVehicleNo() {
        return vehicleNo;
    }

    /**
     * @param vehicleNo the vehicleNo to set
     */
    public BatchModel setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        return this;
    }

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName the driverName to set
     */
    public BatchModel setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    /**
     * @return the helperName
     */
    public String getHelperName() {
        return helperName;
    }

    /**
     * @param helperName the helperName to set
     * @return 
     */
    public BatchModel setHelperName(String helperName) {
        this.helperName = helperName;        
        return this;
    }

    /**
     * @return the count
     */
    public String getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(String count) {
        this.count = count;
    }
}
