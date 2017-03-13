/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.DeliveryOrderDetailModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Oct 28, 2015 Time : 3:18:48 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface DeliveryNoteController extends Remote {

    public boolean addDeliveryOrder(BatchModel batchModel) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<BatchModel> getAllModel() throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addDeliveryOrderDetail(DeliveryOrderDetailModel deliveryOrderDetailModel) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<StockModel> getAllOrderDetail(String consignmentId) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addColour(String colour) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<String> getColours() throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<BikeModel> getBikeModel(String modelId, String announcementId) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateDeliveryNote(BatchModel batchModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean isExistRoundNo(String roundNo) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean deleteDelivery(String consignmentNoteNo) throws ClassNotFoundException, SQLException, RemoteException;
}
