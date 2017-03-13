/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.controller.OrderController;
import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.mixmodel.LeasingOrderModel;
import com.incosyz.sms.mixmodel.OrderSendModel;
import com.incosyz.sms.model.AcountModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.observer.CreateNewSaleObserver;
import com.incosyz.sms.observer.ViewSaleObserver;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 6, 2015 Time : 6:58:55 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderControllerClient {

    public static boolean addOrder(OrderSendModel orderSendModel, GETOrderModel gETOrderModel) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().addOrder(orderSendModel, gETOrderModel);
    }

    public static ArrayList<GETOrderModel> getOrders(int tableRowCount, int showCount) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().getOrders();
    }

    public static ArrayList<GETOrderModel> getOrders(String fromDate, String toDate) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().getOrders(fromDate, toDate);
    }

    public static void addObserver(ViewSaleObserver viewSaleObserver) throws NotBoundException, MalformedURLException, RemoteException {
        ServerConnector.getServerConnector().getOrderController().addObserver(viewSaleObserver);
    }

    public static void removeObserver(ViewSaleObserver viewSaleObserver) throws NotBoundException, MalformedURLException, RemoteException {
        ServerConnector.getServerConnector().getOrderController().removeObserver(viewSaleObserver);
    }

    public static boolean addAccount(AcountModel acountModel) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().addAccount(acountModel);
    }

    public static ArrayList<AcountModel> getAccount(String dateFrom, String dateTo) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().getAccount(dateFrom, dateTo);
    }

    public static ArrayList<CheckModel> getCheque(String dateFrom, String dateTo) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().getCheque(dateFrom, dateTo);
    }

    public static boolean deleteOrder(AcountModel acountModel) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().deleteAccount(acountModel);
    }

    public static boolean addObserver(CreateNewSaleObserver createNewSaleObserver) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().addObserver(createNewSaleObserver);
    }

    public static boolean removeObserver(CreateNewSaleObserver createNewSaleObserver) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().removeObserver(createNewSaleObserver);
    }

    public static boolean leasingExists(String paymentId) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().leasingExists(paymentId);
    }

    public static ArrayList<LeasingOrderModel> getLeasingOrder(String fromDate, String toDate) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getOrderController().getLeasingOrder(fromDate , toDate);
    }
}
