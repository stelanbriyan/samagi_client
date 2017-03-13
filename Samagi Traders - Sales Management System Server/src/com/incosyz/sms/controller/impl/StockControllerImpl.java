/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.StockController;
import com.incosyz.sms.dbcontroller.StockDBController;
import com.incosyz.sms.mixmodel.GETStock;
import com.incosyz.sms.model.ReturnModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 13, 2015 Time : 4:33:49 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class StockControllerImpl extends UnicastRemoteObject implements StockController {

    public StockControllerImpl() throws RemoteException {

    }

    @Override
    public ArrayList<GETStock> getStock(String priceAnnouncementId) throws ClassNotFoundException, SQLException, RemoteException {
        return StockDBController.getStock(priceAnnouncementId);
    }

    @Override
    public boolean addToReturn(ReturnModel model) throws ClassNotFoundException, SQLException, RemoteException {
        return StockDBController.addToReturn(model);
    }

    @Override
    public ArrayList<GETStock> getReturnStock(String price) throws ClassNotFoundException, SQLException, RemoteException {
        return StockDBController.getReturnStock(price);
    }

    @Override
    public boolean deleteStock(String text) throws ClassNotFoundException, SQLException, RemoteException {
        return StockDBController.deleteStock(text);
    }

}
