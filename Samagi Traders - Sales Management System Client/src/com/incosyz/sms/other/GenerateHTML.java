/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.model.CheckModel;
import java.util.ArrayList;

/**
 * Date : Nov 15, 2015 Time : 11:23:52 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class GenerateHTML {

    /**
     * For Cheque HTML Mail
     *
     * @param checkModel
     * @return
     */
    public String getTableHTMLFormat(ArrayList<CheckModel> models) {
        String html = "<html>";
        html += "<body style='font-size:12px'>";

        for (CheckModel checkModel : models) {
            html += getTableHTMLFormat(checkModel);
        }

        html += "</body></html>";
        return html;
    }

    /**
     * For Cheque HTML Mail
     *
     * @param checkModel
     * @return
     */
    private String getTableHTMLFormat(CheckModel checkModel) {
        String html = "";

        html += "<font color='black'>CHEQUE DETAIL</font><br/><br/>";

        html += "<font color='gray'>Cheque No : </font>";
        html += "<font color='black'>" + checkModel.getCheckNo() + "</font><br/><br/>";

        html += "<font color='gray'>Cheque Account : </font>";
        html += "<font color='black'>" + checkModel.getCheckNo() + "</font><br/><br/>";

        html += "<font color='gray'>Cheque Amount : </font>";
        html += "<font color='black'> Rs " + CurrancyFormat.getCurrancyFormat(checkModel.getAmount()) + "</font><br/><br/>";

        html += "<font color='gray'>Bank Name : </font>";
        html += "<font color='black'>" + checkModel.getBankName() + "</font><br/><br/>";

        html += "<font color='gray'>Pay : </font>";
        html += "<font color='black'>" + checkModel.getIssuedBy() + "</font><br/><br/>";

        html += "<font color='gray'>Date : </font>";
        html += "<font color='black'>" + checkModel.getChequeDate() + "</font><br/><br/>";

        html += "<font color='gray'>State : </font>";
        html += "<font color='black'>" + checkModel.getStateName() + "</font><br/><br/>";

        html += "<font color='gray'>Type : </font>";
        html += "<font color='black'>" + checkModel.getType() + "</font><br/><br/>";

        html += "<font color='gray'>Note : </font>";
        html += "<font color='black'>" + checkModel.getNote() + "</font><br/><br/>";

        html += "<font color='gray'>Cheque From Samagi Sales Management System</font><br/>";
        html += "<font color='gray'>Copyright (c) Incosyz Solutions</font><br/>";

        return html;
    }
}
