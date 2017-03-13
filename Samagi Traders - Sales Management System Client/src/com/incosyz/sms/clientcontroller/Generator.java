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
 * Date : Oct 27, 2015 Time : 10:14:10 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Generator {

    public static String generateId(String tableName, String columnName, String prefix, int digitCount) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getId(tableName, columnName, prefix, digitCount);
    }
}
