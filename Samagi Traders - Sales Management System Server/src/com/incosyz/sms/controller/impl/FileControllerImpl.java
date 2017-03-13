/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.FileController;
import com.incosyz.sms.file.FileWriteAccess;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 15, 2015 Time : 1:21:45 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class FileControllerImpl extends UnicastRemoteObject implements FileController {

    FileWriteAccess access = new FileWriteAccess();

    public FileControllerImpl() throws RemoteException {

    }

    @Override
    public boolean saveFile(String fileName, byte[] buffer) {
        try {
            return access.writeFile(fileName, buffer);
        } catch (IOException ex) {
            Logger.getLogger(FileControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public byte[] getFile(String fileName) throws RemoteException {
        try {
            return access.getFile(fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
