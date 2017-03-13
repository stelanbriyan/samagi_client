/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date : Nov 24, 2015 Time : 9:52:49 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface SMS extends Remote {

    public void get() throws RemoteException;
}
