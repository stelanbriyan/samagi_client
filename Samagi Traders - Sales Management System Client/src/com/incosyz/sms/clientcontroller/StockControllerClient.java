/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.mixmodel.GETStock;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.ReturnModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 13, 2015 Time : 4:38:39 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class StockControllerClient {

    public static ArrayList<GETStock> getStock(String priceAnnouncementId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getStockController().getStock(priceAnnouncementId);
    }

    public static boolean addToReturn(ReturnModel model) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getStockController().addToReturn(model);
    }

    public static ArrayList<GETStock> getReturnStock(String price) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getStockController().getReturnStock(price);
    }

    /**
     * Delete stock item form delivery Order
     *
     * @return
     */
    public static OrderModel getOrder(String roundNo) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getOrderController().getOrder(roundNo);
    }

    public static boolean deleteStock(String text) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getStockController().deleteStock(text);
    }
}
