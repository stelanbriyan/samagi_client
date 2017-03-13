/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Stelan
 */
public interface RemoteFactory extends Remote {

    public PriceAnnouncementController getPriceAnnouncementController() throws RemoteException;

    public DeliveryNoteController getDeliveryNoteController() throws RemoteException;

    public SaleController getSaleController() throws RemoteException;

    public OrderController getOrderController() throws RemoteException;

    public CustomerController getCustomerController() throws RemoteException;

    public ChequeController getChequeController() throws RemoteException;

    public StockController getStockController() throws RemoteException;

    public FileController getFileController() throws RemoteException;

    public UserController getUserController() throws RemoteException;

    public BackupController getBackupController() throws RemoteException;

    public PropertyController getPropertyController() throws RemoteException;

    public SMS sms() throws RemoteException;
}
