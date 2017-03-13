/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Date : Nov 20, 2015 Time : 3:28:14 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface BackupController extends Remote {

    public byte[] writeBackup() throws ClassNotFoundException, SQLException, RemoteException;

    public int resortBackup(byte[] b) throws ClassNotFoundException, SQLException, RemoteException;
}
