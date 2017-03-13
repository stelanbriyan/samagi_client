/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.SaleController;
import com.incosyz.sms.dbcontroller.NewSaleDBController;
import com.incosyz.sms.mixmodel.SaleBikeDetailModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.NoteTableModel;
import com.incosyz.sms.model.SpecialDealerModel;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 1, 2015 Time : 5:36:01 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SaleControllerImpl extends UnicastRemoteObject implements SaleController {

    public SaleControllerImpl() throws RemoteException {

    }

    @Override
    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail() throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getAllSaleBikeDetail();
    }

    @Override
    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail(String roundNo) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getAllSaleBikeDetail(roundNo);
    }

    @Override
    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailModelName(String modelName) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getAllSaleBikeDetailModelName(modelName);
    }

    @Override
    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailColour(String colour) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getAllSaleBikeDetailColour(colour);
    }

    @Override
    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailChassis(String chassisNo) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getAllSaleBikeDetailChassis(chassisNo);
    }

    @Override
    public SpecialDealerModel getSpecialConsignmentDealer(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getSpecialConsignmentDealer(bikeModelId);
    }

    @Override
    public CheckModel getCheque(String chequeNumber) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getCheque(chequeNumber);
    }

    @Override
    public ArrayList<SaleBikeDetailModel> getEngine(String text) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getEngine(text);
    }

    @Override
    public boolean saveNote(String orderId, String note) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.saveNote(orderId, note);
    }

    @Override
    public NoteTableModel getNoteTableModel(String orderId) throws RemoteException, ClassNotFoundException, SQLException {
        return NewSaleDBController.getNoteTableModel(orderId);
    }

    @Override
    public NoteTableModel getNoteTable(String orderId) throws RemoteException, ClassNotFoundException, SQLException {

        return NewSaleDBController.getNoteTableModel(orderId);
    }

    @Override
    public void report(String orderId) throws RemoteException, ClassNotFoundException, SQLException {
        NewSaleDBController.report(orderId);
    }

    @Override
    public boolean deleteSale(String roundNo) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        boolean deleteSale = NewSaleDBController.deleteSale(roundNo);
        return deleteSale;
    }
}
