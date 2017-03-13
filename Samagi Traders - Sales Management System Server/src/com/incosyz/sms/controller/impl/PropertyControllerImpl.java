/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.PropertyController;
import com.incosyz.sms.property.Setting;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 23, 2015 Time : 3:22:06 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class PropertyControllerImpl extends UnicastRemoteObject implements PropertyController {

    private Setting s;

    public PropertyControllerImpl() throws RemoteException {
        try {
            s = new Setting();
        } catch (IOException ex) {
            Logger.getLogger(PropertyControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setProperty(String name, String property) throws RemoteException {
        try {
            s.setProperty(name, property);
        } catch (IOException ex) {
            Logger.getLogger(PropertyControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getProperty(String name) throws RemoteException {
        return s.getProperty(name);
    }

}
