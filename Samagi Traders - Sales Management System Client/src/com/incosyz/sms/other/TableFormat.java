/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Date : Nov 10, 2015 Time : 11:52:28 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class TableFormat extends DefaultTableCellRenderer {

    private ArrayList<Integer> notPayList;
    private int colourBRed = 0;
    private int colourBGreen = 0;
    private int colourBBlue = 0;

    private int colourFRed = 250;
    private int colourFGreen = 250;
    private int colourFBlue = 250;

    private int colourBSRed = 51;
    private int colourBSGreen = 153;
    private int colourBSBlue = 255;

    private int colourFSRed = 250;
    private int colourFSGreen = 250;
    private int colourFSBlue = 250;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = null;

        if (notPayList != null & notPayList.contains(row)) {
            c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(new Color(colourBRed, colourBGreen, colourBBlue));
            c.setForeground(new Color(colourFRed, colourFGreen, colourFBlue));
            if (isSelected) {
                c.setBackground(new Color(colourBSRed, colourBSGreen, colourBSBlue));
                c.setForeground(new Color(colourFSRed, colourFSGreen, colourFSBlue));
            }

            return c;
        }

        c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
        if (isSelected) {
            c.setBackground(new Color(51, 153, 255));
            c.setForeground(Color.WHITE);
        }
        return c;
    }

    public void setCellBackground(int r, int g, int b) {
        colourBRed = r;
        colourBGreen = g;
        colourBBlue = b;
    }

    public void setSelectedCellBackground(int r, int g, int b) {
        colourBSRed = r;
        colourBSGreen = g;
        colourBSBlue = b;
    }

    public void setCellForeground(int r, int g, int b) {
        colourFBlue = r;
        colourFGreen = r;
        colourFRed = r;
    }

    public void setSelectedCellForeground(int r, int g, int b) {
        colourFSBlue = r;
        colourFSGreen = r;
        colourFSRed = r;
    }

    /**
     * @return the notPayList
     */
    public ArrayList<Integer> getNotPayList() {
        return notPayList;
    }

    /**
     * @param notPayList the notPayList to set
     */
    public void setNotPayList(ArrayList<Integer> notPayList) {
        this.notPayList = notPayList;
    }

}
