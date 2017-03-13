/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.GETStock;
import com.incosyz.sms.model.ReturnModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 13, 2015 Time : 4:32:00 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface StockController extends Remote {

    public ArrayList<GETStock> getStock(String priceAnnouncementId) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addToReturn(ReturnModel model) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<GETStock> getReturnStock(String price) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean deleteStock(String text) throws ClassNotFoundException, SQLException, RemoteException;
}
