/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.mixmodel.SaleBikeDetailModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.NoteTableModel;
import com.incosyz.sms.model.SpecialDealerModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 1, 2015 Time : 5:54:54 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SaleControllerImplClient {

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetail() throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getAllSaleBikeDetail();
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetail(String roundNo) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getAllSaleBikeDetail(roundNo);
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetailModelName(String modelName) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getAllSaleBikeDetailModelName(modelName);
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetailColour(String colour) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getAllSaleBikeDetailColour(colour);
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetailChassis(String chassis) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getAllSaleBikeDetailChassis(chassis);
    }

    public static SpecialDealerModel getSpecialConsignmentDealer(String bikeModelId) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getSpecialConsignmentDealer(bikeModelId);
    }

    public static CheckModel getCheque(String chequeNumber) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getCheque(chequeNumber);
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleDetailEngine(String text) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getEngine(text);
    }

    public static boolean saveNote(String orderId, String note) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().saveNote(orderId, note);
    }

    public static NoteTableModel getInfoNoteTable(String orderId) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().getNoteTable(orderId);
    }

    public static void reported(String orderId) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        ServerConnector.getServerConnector().getSaleController().report(orderId);
    }

    public static boolean deleteSale(String roundNo) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getSaleController().deleteSale(roundNo);
    }
}
