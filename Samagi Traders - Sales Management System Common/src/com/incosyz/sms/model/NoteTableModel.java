/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.incosyz.sms.model;

import java.io.Serializable;

/**
 *
 * @author Stelan-PC
 */
public class NoteTableModel implements Serializable{
    private String orderId ;
    private String noteTableId;
    private String note;
    private String isReport;

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

    /**
     * @return the noteTableId
     */
    public String getNoteTableId() {
        return noteTableId;
    }

    /**
     * @param noteTableId the noteTableId to set
     */
    public void setNoteTableId(String noteTableId) {
        this.noteTableId = noteTableId;
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
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the isReport
     */
    public String getIsReport() {
        return isReport;
    }

    /**
     * @param isReport the isReport to set
     */
    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }
}
