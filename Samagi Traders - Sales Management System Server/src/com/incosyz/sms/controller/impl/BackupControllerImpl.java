/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.BackupController;
import com.incosyz.sms.dbcontroller.BackupProgress;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 20, 2015 Time : 3:27:10 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class BackupControllerImpl extends UnicastRemoteObject implements BackupController {

    public BackupControllerImpl() throws RemoteException {

    }

    @Override
    public byte[] writeBackup() throws ClassNotFoundException, SQLException, RemoteException {
        byte[] writeBackup = null;
        try {
            writeBackup = BackupProgress.writeBackup();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(BackupControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return writeBackup;
    }

    @Override
    public int resortBackup(byte[] b) throws ClassNotFoundException, SQLException, RemoteException {
        try {
            return BackupProgress.restoreBackup(b);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(BackupControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
