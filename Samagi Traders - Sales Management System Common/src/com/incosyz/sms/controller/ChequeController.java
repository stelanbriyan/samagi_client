/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.model.CheckModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 11, 2015 Time : 11:49:03 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface ChequeController extends Remote {

    public boolean addCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<CheckModel> getCheque() throws ClassNotFoundException, SQLException, RemoteException;

    public boolean deleteCheque(String chequeId) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean changeState(String state, String chequeId) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<CheckModel> getCheque(String paymentId) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<CheckModel> getTodayCheque() throws ClassNotFoundException, SQLException, RemoteException;

    public boolean getIsExists(String chequeNo1) throws ClassNotFoundException, SQLException, RemoteException;
}
