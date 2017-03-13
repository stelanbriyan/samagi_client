/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date : Nov 23, 2015 Time : 3:21:41 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface PropertyController extends Remote {

    public void setProperty(String name, String property) throws RemoteException;

    public String getProperty(String name) throws RemoteException;

}
