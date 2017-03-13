/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.SMS;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Date : Nov 24, 2015 Time : 9:52:10 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SMSImpl extends UnicastRemoteObject implements SMS {

    public SMSImpl() throws RemoteException {

    }

    @Override
    public void get() throws RemoteException {
        
    }
}
