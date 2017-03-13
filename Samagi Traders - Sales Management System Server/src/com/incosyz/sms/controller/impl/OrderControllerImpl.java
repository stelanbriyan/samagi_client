/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.OrderController;
import com.incosyz.sms.dbcontroller.OrderDBController;
import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.mixmodel.LeasingOrderModel;
import com.incosyz.sms.mixmodel.OrderSendModel;
import com.incosyz.sms.model.AcountModel;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.observer.CreateNewSaleObserver;
import com.incosyz.sms.observer.ViewSaleObserver;
import com.incosyz.sms.observer.impl.CreateNewSaleObserverImpl;
import com.incosyz.sms.observer.impl.ViewSaleObserverImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 6, 2015 Time : 6:04:23 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderControllerImpl extends UnicastRemoteObject implements OrderController {

    private final static ViewSaleObserverImpl VIEW_SALE_OBSERVER = new ViewSaleObserverImpl();
    private final static CreateNewSaleObserverImpl CREATE_NEW_SALE_OBSERVER_IMPL = new CreateNewSaleObserverImpl();

    public OrderControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addOrder(OrderSendModel orderSendModel, GETOrderModel gETOrderModel) throws RemoteException, ClassNotFoundException, SQLException {
        boolean addOrder = OrderDBController.addOrder(orderSendModel);
        System.out.println("A");
        if (addOrder) {
//            VIEW_SALE_OBSERVER.addNewOrder(gETOrderModel);
//            CREATE_NEW_SALE_OBSERVER_IMPL.removeStockItem(gETOrderModel.getOrderModel().getRoundNo());
        }

        System.out.println("B");
        return addOrder;
    }

    public ArrayList<GETOrderModel> getOrders() throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getOrders();
    }

    @Override
    public void addObserver(ViewSaleObserver viewSaleObserver) throws RemoteException {
        VIEW_SALE_OBSERVER.addObserver(viewSaleObserver);
    }

    @Override
    public void removeObserver(ViewSaleObserver viewSaleObserver) throws RemoteException {
        VIEW_SALE_OBSERVER.removeObserver(viewSaleObserver);
    }

    @Override
    public ArrayList<GETOrderModel> getOrders(String fromDate, String toDate) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getOrders(fromDate, toDate);
    }

    @Override
    public boolean addAccount(AcountModel acountModel) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.addAccount(acountModel);
    }

    @Override
    public ArrayList<AcountModel> getAccount(String dateFrom, String dateTo) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getAccount(dateFrom, dateTo);
    }

    @Override
    public ArrayList<CheckModel> getCheque(String dateFrom, String dateTo) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getCheque(dateFrom, dateTo);
    }

    public boolean deleteAccount(AcountModel acountModel) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.deleteAcount(acountModel);
    }

    @Override
    public boolean addObserver(CreateNewSaleObserver createNewSaleObserver) throws RemoteException, ClassNotFoundException, SQLException {
        return CREATE_NEW_SALE_OBSERVER_IMPL.addObserver(createNewSaleObserver);
    }

    @Override
    public boolean removeObserver(CreateNewSaleObserver createNewSaleObserver) throws RemoteException, ClassNotFoundException, SQLException {
        return CREATE_NEW_SALE_OBSERVER_IMPL.removeObserver(createNewSaleObserver);
    }

    @Override
    public OrderModel getOrder(String roundNo) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getOrder(roundNo);
    }

    @Override
    public boolean leasingExists(String paymentId) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.leasingExists(paymentId);
    }

    @Override
    public ArrayList<LeasingOrderModel> getLeasingOrder(String fromDate, String toDate) throws RemoteException, ClassNotFoundException, SQLException {
        return OrderDBController.getLeasingDetail(fromDate, toDate);
    }
}
