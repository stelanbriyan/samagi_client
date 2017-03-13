/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.UserOrderModel;
import com.incosyz.sms.model.UserModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 18, 2015 Time : 5:48:07 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface UserController extends Remote {

    public int getUserCount() throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addUser(UserModel model) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<UserModel> getUsers() throws ClassNotFoundException, SQLException, RemoteException;

    public boolean deleteUser(String userId) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<UserOrderModel> getUserOrder() throws ClassNotFoundException, SQLException, RemoteException;
}
