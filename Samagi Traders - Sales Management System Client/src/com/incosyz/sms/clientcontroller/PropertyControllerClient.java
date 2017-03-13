/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Date : Nov 23, 2015 Time : 3:19:25 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class PropertyControllerClient {

    public static void setProperty(String name, String property) throws NotBoundException, MalformedURLException, RemoteException {
        try {
            ServerConnector.getServerConnector().getPropertyController().setProperty(name, property);
        } catch (Exception e) {
            
        }
    }

    public static String getProperty(String name) throws NotBoundException, MalformedURLException, RemoteException {
        try {
            return ServerConnector.getServerConnector().getPropertyController().getProperty(name);
        } catch (Exception e) {
            return null;
        }
    }
}
