/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.mixmodel.GETStock;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 * Date : Nov 14, 2015 Time : 10:37:39 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SearchStockTable {

    private ArrayList<GETStock> stocks;

    public ArrayList<GETStock> filterTable(ArrayList<GETStock> gETStocks, int columnIndex, String searchText) {
        stocks = new ArrayList<>();
        for (GETStock gETStock : gETStocks) {
            String text = getText(gETStock, columnIndex);
            if (text.toLowerCase().contains(searchText.toLowerCase())) {
                stocks.add(gETStock);
            }
        }
        return stocks;
    }

    public String getText(GETStock gETStock, int columnIndex) {
        if (columnIndex == 0) {
            return gETStock.getStockModel().getRoundNo();
        } else if (columnIndex == 1) {
            return gETStock.getModel().getModelName();
        } else if (columnIndex == 2) {
            return gETStock.getStockModel().getEngineNo();
        } else if (columnIndex == 3) {
            return gETStock.getStockModel().getChassisNo();
        } else if (columnIndex == 4) {
            return gETStock.getStockModel().getColour();
        } else if (columnIndex == 5) {
            return gETStock.getBikeModel().getBikeOption();
        } else if (columnIndex == 6) {
            return gETStock.getBikeModel().getCapacity();
        } else if (columnIndex == 7) {
            return gETStock.getBikeModel().getCommision();
        } else if (columnIndex == 8) {
            return gETStock.getBikeModel().getNetAmount();
        }
        return null;
    }
}
