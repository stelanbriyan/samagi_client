/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 12, 2015 Time : 12:08:09 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ChequeControllerClient {

    public static boolean addCheque(CheckModel checkModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().addCheque(checkModel);
    }

    public static ArrayList<CheckModel> getCheque() throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().getCheque();
    }

    public static boolean updateCheque(CheckModel checkModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().updateCheque(checkModel);
    }

    public static boolean deleteCheque(String chequeId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().deleteCheque(chequeId);
    }

    public static boolean changeState(String state, String chequeId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().changeState(state, chequeId);
    }

    public static ArrayList<CheckModel> getCheque(String paymentId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().getCheque(paymentId);
    }

    public static ArrayList<CheckModel> getTodayCheque() throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().getTodayCheque();
    }

    public static boolean isExist(String chequeNo1) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getChequeController().getIsExists(chequeNo1);
    }

}
