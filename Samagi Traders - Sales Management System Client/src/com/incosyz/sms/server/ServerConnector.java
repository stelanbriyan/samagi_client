/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.server;

import com.incosyz.sms.controller.BackupController;
import com.incosyz.sms.controller.ChequeController;
import com.incosyz.sms.controller.CustomerController;
import com.incosyz.sms.controller.DeliveryNoteController;
import com.incosyz.sms.controller.FileController;
import com.incosyz.sms.controller.OrderController;
import com.incosyz.sms.controller.PriceAnnouncementController;
import com.incosyz.sms.controller.PropertyController;
import com.incosyz.sms.controller.RemoteFactory;
import com.incosyz.sms.controller.SMS;
import com.incosyz.sms.controller.SaleController;
import com.incosyz.sms.controller.StockController;
import com.incosyz.sms.controller.UserController;
import com.incosyz.sms.dialog.ServerConnect;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stelan
 */
public class ServerConnector {

    public static String ip = "localhost";

    private static ServerConnector serverConnector;
    private RemoteFactory remoteFactory;
    private PriceAnnouncementController priceAnnouncementController;
    private DeliveryNoteController deliveryNoteController;
    private SaleController saleController;
    private OrderController orderController;
    private CustomerController customerController;
    private ChequeController chequeController;
    private StockController stockController;
    private FileController fileController;
    private UserController userController;
    private BackupController backupController;
    private PropertyController propertyController;
    private SMS sms;

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        try {
            remoteFactory = (RemoteFactory) Naming.lookup("rmi://" + ip + ":5050/sms");
        } catch (Exception e) {
            ServerConnect serverConnect = new ServerConnect();
            serverConnect.setAlwaysOnTop(true);
            serverConnect.setVisible(true);
        }
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }

    public boolean isConnectionReady() {
        try {
            getSMS();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setServerConnector() {
        serverConnector = null;
    }

    public boolean setRemote() throws NotBoundException, RemoteException, MalformedURLException {
        try {
            remoteFactory = (RemoteFactory) Naming.lookup("rmi://" + ip + ":5050/sms");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PriceAnnouncementController getPriceAnnouncementController() throws RemoteException {
//        ServerChecking.checkServer();
        if (priceAnnouncementController == null) {
            priceAnnouncementController = remoteFactory.getPriceAnnouncementController();
        }
        return priceAnnouncementController;
    }

    public DeliveryNoteController getDeliveryNoteController() throws RemoteException {
//        ServerChecking.checkServer();
        if (deliveryNoteController == null) {
            deliveryNoteController = remoteFactory.getDeliveryNoteController();
        }
        return deliveryNoteController;
    }

    public SaleController getSaleController() throws RemoteException {
//        ServerChecking.checkServer();
        if (saleController == null) {
            saleController = remoteFactory.getSaleController();
        }
        return saleController;
    }

    public OrderController getOrderController() throws RemoteException {
//        ServerChecking.checkServer();
        if (orderController == null) {
            orderController = remoteFactory.getOrderController();
        }
        return orderController;
    }

    public CustomerController getCustomerController() throws RemoteException {
//        ServerChecking.checkServer();
        if (customerController == null) {
            customerController = remoteFactory.getCustomerController();
        }
        return customerController;
    }

    public ChequeController getChequeController() throws RemoteException {
//        ServerChecking.checkServer();
        if (chequeController == null) {
            chequeController = remoteFactory.getChequeController();
        }
        return chequeController;
    }

    public StockController getStockController() throws RemoteException {
//        ServerChecking.checkServer();
        if (stockController == null) {
            stockController = remoteFactory.getStockController();
        }
        return stockController;
    }

    public FileController getFileController() throws RemoteException {
//        ServerChecking.checkServer();
        if (fileController == null) {
            fileController = remoteFactory.getFileController();
        }
        return fileController;
    }

    public UserController getUserController() throws RemoteException {
//        ServerChecking.checkServer();
        if (userController == null) {
            userController = remoteFactory.getUserController();
        }
        return userController;
    }

    public BackupController getBackupController() throws RemoteException {
//        ServerChecking.checkServer();
        if (backupController == null) {
            backupController = remoteFactory.getBackupController();
        }
        return backupController;
    }

    public PropertyController getPropertyController() throws RemoteException {
//        ServerChecking.checkServer();
        if (propertyController == null) {
            propertyController = remoteFactory.getPropertyController();
        }
        return propertyController;
    }

    public SMS getSMS() throws RemoteException {
        if (sms == null) {
            sms = remoteFactory.sms();
        }
        return sms;
    }
}
