/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date : Nov 15, 2015 Time : 1:20:34 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface FileController extends Remote {

    public boolean saveFile(String fileName, byte[] buffer) throws RemoteException;

    
    
    public byte[] getFile(String fileName) throws RemoteException;
}
