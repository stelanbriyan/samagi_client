/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.server;


/**
 * Date : Nov 24, 2015 Time : 7:22:13 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ServerChecking {

    public static boolean isServerAvailable() {
        try {
            ServerConnector.getServerConnector().getSMS().get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
