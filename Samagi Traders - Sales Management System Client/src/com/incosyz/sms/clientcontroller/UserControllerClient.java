/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.mixmodel.UserOrderModel;
import com.incosyz.sms.model.UserModel;
import com.incosyz.sms.server.ServerConnector;
import com.sun.mail.iap.ConnectionException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Date : Nov 18, 2015 Time : 5:47:27 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UserControllerClient {

    public static boolean addUser(UserModel userModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getUserController().addUser(userModel);
    }

    public static ArrayList<UserModel> getUsers() throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        ArrayList<UserModel> users = ServerConnector.getServerConnector().getUserController().getUsers();

        return users;
    }

    public static boolean deleteUser(String userId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getUserController().deleteUser(userId);
    }

    public static ArrayList<UserOrderModel> getUserLogger() throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getUserController().getUserOrder();
    }
}
