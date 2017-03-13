/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.mixmodel.LeasingOrderModel;
import com.incosyz.sms.mixmodel.OrderSendModel;
import com.incosyz.sms.model.AcountModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.observer.CreateNewSaleObserver;
import com.incosyz.sms.observer.ViewSaleObserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 6, 2015 Time : 4:26:46 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface OrderController extends Remote {

    public boolean addOrder(OrderSendModel orderSendModel, GETOrderModel gETOrderModel) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<GETOrderModel> getOrders() throws RemoteException, ClassNotFoundException, SQLException;

    public void addObserver(ViewSaleObserver viewSaleObserver) throws RemoteException;

    public void removeObserver(ViewSaleObserver viewSaleObserver) throws RemoteException;

    public ArrayList<GETOrderModel> getOrders(String fromDate, String toDate) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addAccount(AcountModel acountModel) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<AcountModel> getAccount(String dateFrom, String dateTo) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<CheckModel> getCheque(String dateFrom, String dateTo) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteAccount(AcountModel acountModel) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addObserver(CreateNewSaleObserver createNewSaleObserver) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean removeObserver(CreateNewSaleObserver createNewSaleObserver) throws RemoteException, ClassNotFoundException, SQLException;

    public OrderModel getOrder(String roundNo) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean leasingExists(String paymentId) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<LeasingOrderModel> getLeasingOrder(String fromDate, String toDate)throws RemoteException, ClassNotFoundException, SQLException;

    
}
