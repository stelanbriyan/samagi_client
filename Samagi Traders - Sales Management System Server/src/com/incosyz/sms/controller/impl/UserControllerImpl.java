/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.UserController;
import com.incosyz.sms.dbcontroller.UserDBController;
import com.incosyz.sms.mixmodel.UserOrderModel;
import com.incosyz.sms.model.UserModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 18, 2015 Time : 5:48:27 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UserControllerImpl extends UnicastRemoteObject implements UserController {

    public UserControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addUser(UserModel model) throws ClassNotFoundException, SQLException, RemoteException {
        return UserDBController.addUser(model);
    }

    @Override
    public ArrayList<UserModel> getUsers() throws ClassNotFoundException, SQLException, RemoteException {
        return UserDBController.getUsers();
    }

    @Override
    public boolean deleteUser(String userId) throws ClassNotFoundException, SQLException, RemoteException {
        return UserDBController.deleteUser(userId);
    }

    @Override
    public ArrayList<UserOrderModel> getUserOrder() throws ClassNotFoundException, SQLException, RemoteException {
        return UserDBController.getUserLogger();
    }        

    @Override
    public int getUserCount() {
        try {
            return UserDBController.getUserCount();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
