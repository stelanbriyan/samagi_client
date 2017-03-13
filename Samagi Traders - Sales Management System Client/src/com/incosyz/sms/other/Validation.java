/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Date : Nov 8, 2015 Time : 1:35:27 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Validation {

    public void validateContactNo(JTextField field) {
        String text = field.getText();
        field.setText(text.replaceAll("[\\D]", ""));

        if (text.length() >= 10) {
            text = text.substring(0, 10);
            field.setText(text);
        }
    }

    /**
     * Validate is number or not and replace string
     *
     * @param field
     */
    public void validateNumber(JTextField field) {
        String text = field.getText();
        field.setText(text.replaceAll("[\\D]", ""));
    }

    private static boolean CheckNumber(String number) {
        boolean isNumber = false;
        try {
            Long.parseLong(number);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }

    /**
     * return is phone number or not
     *
     * @param text
     * @return
     */
    public static boolean validatePhoneNumber(String text) {
        String regex = "^0[1-9]{2}[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public void validateForCurrency(JTextField field) {
        String s = field.getText();
        if (checkNumberForCurrency(s)) {
            field.setText(s);
        } else {
            field.setText(s.substring(0, s.length() - 1));
        }
    }

    public boolean checkNumberForCurrency(String s) {
        boolean isNumber = true;
        try {
            Double.parseDouble(s + "0");
            isNumber = true;
        } catch (Exception e) {
            isNumber = false;
        }
        return isNumber;
    }

    public boolean inputCurrancy(JTextField field) {
        String text = field.getText();
        String pattern = "^\\$?(?:0|[1-9]\\d*|[1-9]\\d{0,2}(?:,\\d{1,3})*)(?:\\.\\d{2})?$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        if (m.find()) {
            field.setForeground(Color.BLACK);
        } else {
            field.setForeground(Color.RED);
        }
        return m.find();
    }

    /*Validation Method for Decimal*/
    public boolean validateWithPoing(String text) {
        String regex = "^[[0-9][.][0-9]{2}]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public boolean validateNIC(String text) {
        String regex = "^/d{9}(X|V)$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }


}
