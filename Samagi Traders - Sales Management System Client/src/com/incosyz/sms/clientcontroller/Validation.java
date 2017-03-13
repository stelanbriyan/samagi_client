/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.incosyz.sms.clientcontroller;

/**
 * Date : Oct 27, 2015
 * Time : 6:49:18 PM
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Validation {
    public static boolean isNumber(String text){
        String reg = "[0-9]+";    
        return text.matches(reg);
    }
}
