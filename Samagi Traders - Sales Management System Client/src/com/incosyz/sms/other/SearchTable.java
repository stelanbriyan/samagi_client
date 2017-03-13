/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.mixmodel.GETOrderModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Date : Nov 11, 2015 Time : 1:57:28 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SearchTable {

    private ArrayList<GETOrderModel> newGETOrderModels;

    public SearchTable() {
        newGETOrderModels = new ArrayList<>();
    }

    public ArrayList<GETOrderModel> filterTable(ArrayList<GETOrderModel> gETOrderModels, int coloumnIndex, String searchText) {
        newGETOrderModels = new ArrayList<>();
        for (int i = 0; i < gETOrderModels.size(); i++) {
            String text = getSearchText(gETOrderModels, i, coloumnIndex);
            if (text.toLowerCase().contains(searchText.toLowerCase())) {
                newGETOrderModels.add(gETOrderModels.get(i));
            }
        }
        return newGETOrderModels;
    }

    public String getSearchText(ArrayList<GETOrderModel> gETOrderModels, int rowIndex, int coloumnIndex) {
        if (coloumnIndex == 0) {
            return gETOrderModels.get(rowIndex).getOrderModel().getRoundNo();
        } else if (coloumnIndex == 1) {
            return gETOrderModels.get(rowIndex).getModel().getModelName();
        } else if (coloumnIndex == 2) {
            return gETOrderModels.get(rowIndex).getCustomerModel().getCustomerName();
        } else if (coloumnIndex == 3) {
            return gETOrderModels.get(rowIndex).getCustomerModel().getNicNo();
        } else if (coloumnIndex == 4) {
            return gETOrderModels.get(rowIndex).getOrderModel().getOrderDate();
        } else if (coloumnIndex == 5) {
//            return gETOrderModels.get(rowIndex).getBikeModel().getC();
        }
        return "";
    }
}
