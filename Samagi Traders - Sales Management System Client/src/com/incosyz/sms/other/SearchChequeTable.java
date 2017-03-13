/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.model.CheckModel;
import java.util.ArrayList;

/**
 * Date : Nov 12, 2015 Time : 7:13:09 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SearchChequeTable {

    private ArrayList<CheckModel> filterCheckModels;

    public SearchChequeTable() {
//        filterCheckModels = new ArrayList<>();
    }

    public ArrayList<CheckModel> filterTable(ArrayList<CheckModel> checkModels, int columnIndex, String searchText) {
        filterCheckModels = new ArrayList<>();
        for (CheckModel checkModel : checkModels) {
            String text = getText(checkModel, columnIndex);
            if (text.toLowerCase().contains(searchText.toLowerCase())) {
                filterCheckModels.add(checkModel);
            }
        }
        return filterCheckModels;
    }

    private String getText(CheckModel checkModel, int columnIndex) {
        if (columnIndex == 0) {
            return checkModel.getCheckNo();
        } else if (columnIndex == 1) {
            return checkModel.getBankName();
        } else if (columnIndex == 2) {
            return checkModel.getIssuedBy();
        } else if (columnIndex == 3) {
            return checkModel.getChequeDate();
        } else if (columnIndex == 4) {
            if (checkModel.getStateName() == null) {
                return "";
            }
            return checkModel.getStateName();
        } else if (columnIndex == 5) {
            if (checkModel.getType() == null) {
                return "";
            }
            return checkModel.getType();
        } else if (columnIndex == 6) {
            if (checkModel.getNote() == null) {
                return "";
            }
            return checkModel.getNote();
        }
        return "";
    }
}
