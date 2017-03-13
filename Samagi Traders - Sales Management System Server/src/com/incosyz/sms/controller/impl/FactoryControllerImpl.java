/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.BackupController;
import com.incosyz.sms.controller.ChequeController;
import com.incosyz.sms.controller.CustomerController;
import com.incosyz.sms.controller.DeliveryNoteController;
import com.incosyz.sms.controller.FileController;
import com.incosyz.sms.controller.OrderController;
import com.incosyz.sms.controller.RemoteFactory;
import com.incosyz.sms.controller.PriceAnnouncementController;
import com.incosyz.sms.controller.PropertyController;
import com.incosyz.sms.controller.SMS;
import com.incosyz.sms.controller.SaleController;
import com.incosyz.sms.controller.StockController;
import com.incosyz.sms.controller.UserController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Stelan
 */
public class FactoryControllerImpl extends UnicastRemoteObject implements RemoteFactory {

    public FactoryControllerImpl() throws RemoteException {

    }

    @Override
    public PriceAnnouncementController getPriceAnnouncementController() throws RemoteException {
        return new PriceAnnouncementControllerImpl();
    }

    @Override
    public DeliveryNoteController getDeliveryNoteController() throws RemoteException {
        return new DeliveryNoteControllerImpl();
    }

    @Override
    public SaleController getSaleController() throws RemoteException {
        return new SaleControllerImpl();
    }

    @Override
    public OrderController getOrderController() throws RemoteException {
        return new OrderControllerImpl();
    }

    @Override
    public CustomerController getCustomerController() throws RemoteException {
        return new CustomerControllerImpl();
    }

    @Override
    public ChequeController getChequeController() throws RemoteException {
        return new ChequeControllerImpl();
    }

    @Override
    public StockController getStockController() throws RemoteException {
        return new StockControllerImpl();
    }

    @Override
    public FileController getFileController() throws RemoteException {
        return new FileControllerImpl();
    }

    @Override
    public UserController getUserController() throws RemoteException {
        return new UserControllerImpl();
    }

    @Override
    public BackupController getBackupController() throws RemoteException {
        return new BackupControllerImpl();
    }

    @Override
    public PropertyController getPropertyController() throws RemoteException {
        return new PropertyControllerImpl();
    }

    @Override
    public SMS sms() throws RemoteException {
        return new SMSImpl();
    }
}
