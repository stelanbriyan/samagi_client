/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Date : Nov 4, 2015 Time : 12:41:40 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CurrancyFormat {

    public static String getCurrancyFormat(double d) {
        if (d < 0) {

            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            String formatNumber = numberFormat.format(-d);
            return "-" +formatNumber.substring(1,  formatNumber.length());

        } else {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            String formatNumber = numberFormat.format(d);
            return formatNumber.substring(1, formatNumber.length());

        }
    }

    public static String getCurrancyFormat(String curr) {
        Double d = Double.parseDouble(curr);
        return getCurrancyFormat(d);
    }

    public static String getCurrancyFormat(int curr) {
        Double d = Double.parseDouble(String.valueOf(curr));
        return getCurrancyFormat(d);
    }

    public static double getDecimal(String currancy) {
        if ("".equals(currancy) || currancy == null) {
            return 0;
        }

        String nonCentz = currancy.substring(0, currancy.length() - 3);
        String[] numbers = nonCentz.split(",");
        String value = "";
        for (int i = 0; i < numbers.length; i++) {
            value += numbers[i];
        }
        value += currancy.substring(currancy.length() - 3, currancy.length());
        return Double.parseDouble(value);
    }

}
