/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.SaleBikeDetailModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.NoteTableModel;
import com.incosyz.sms.model.SpecialDealerModel;
import com.incosyz.sms.observer.CreateNewSaleObserver;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 1, 2015 Time : 5:36:39 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface SaleController extends Remote {

    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail() throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail(String roundNo) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailModelName(String modelName) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailColour(String colour) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailChassis(String chassisNo) throws RemoteException, ClassNotFoundException, SQLException;

    public SpecialDealerModel getSpecialConsignmentDealer(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException;

    public CheckModel getCheque(String chequeNumber) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SaleBikeDetailModel> getEngine(String text) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean saveNote(String orderId, String note) throws RemoteException, ClassNotFoundException, SQLException;

    public NoteTableModel getNoteTableModel(String orderId) throws RemoteException, ClassNotFoundException, SQLException;

    public NoteTableModel getNoteTable(String orderId) throws RemoteException, ClassNotFoundException, SQLException;

    public void report(String orderId) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteSale(String roundNo) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException;

}
