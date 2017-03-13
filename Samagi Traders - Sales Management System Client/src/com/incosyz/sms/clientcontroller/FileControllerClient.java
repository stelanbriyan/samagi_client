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

/**
 * Date : Nov 15, 2015 Time : 1:29:44 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class FileControllerClient {

    public static boolean saveFile(String fileName, byte[] buffer) throws NotBoundException, MalformedURLException, RemoteException {
        return ServerConnector.getServerConnector().getFileController().saveFile(fileName, buffer);
    }

    public static byte[] getFile(String fileName) throws NotBoundException, MalformedURLException, RemoteException {
        return ServerConnector.getServerConnector().getFileController().getFile(fileName);
    }
}
