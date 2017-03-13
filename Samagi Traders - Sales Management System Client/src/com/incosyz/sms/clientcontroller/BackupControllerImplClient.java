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
import java.sql.SQLException;

/**
 * Date : Nov 20, 2015 Time : 3:33:11 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class BackupControllerImplClient {

    public static byte[] writeBackup() throws NotBoundException, ClassNotFoundException, MalformedURLException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getBackupController().writeBackup();
    }

    public static int resortBackup(byte[] b) throws NotBoundException, ClassNotFoundException, MalformedURLException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getBackupController().resortBackup(b);
    }

}
