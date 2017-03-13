/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.config;

import com.incosyz.sms.clientcontroller.PropertyControllerClient;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 11, 2015 Time : 9:53:32 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Setting {

   
    public Setting() throws IOException {

    }

    public void setProperty(String name, String property) throws IOException {
        try {
            PropertyControllerClient.setProperty(name, property);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProperty(String name) {
        String property = null;
        try {
            property = PropertyControllerClient.getProperty(name);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return property;
    }
}
