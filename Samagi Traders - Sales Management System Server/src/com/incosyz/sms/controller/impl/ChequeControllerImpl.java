/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.ChequeController;
import com.incosyz.sms.dbcontroller.ChequeDBController;
import com.incosyz.sms.model.CheckModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 11, 2015 Time : 11:50:00 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ChequeControllerImpl extends UnicastRemoteObject implements ChequeController {

    public ChequeControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.addCheque(checkModel);
    }

    @Override
    public ArrayList<CheckModel> getCheque() throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.getCheque();
    }

    @Override
    public boolean updateCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.updateCheque(checkModel);
    }

    @Override
    public boolean deleteCheque(String chequeId) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.deleteCheque(chequeId);
    }

    @Override
    public boolean changeState(String state, String chequeId) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.stateChange(state, chequeId);
    }

    @Override
    public ArrayList<CheckModel> getCheque(String paymentId) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.getCheque(paymentId);
    }

    @Override
    public ArrayList<CheckModel> getTodayCheque() throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.getTodayCheque();
    }

    @Override
    public boolean getIsExists(String chequeNo1) throws ClassNotFoundException, SQLException, RemoteException {
        return ChequeDBController.isExists(chequeNo1);
    }

}
