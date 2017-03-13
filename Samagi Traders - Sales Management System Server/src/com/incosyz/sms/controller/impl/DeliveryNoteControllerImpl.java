/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.DeliveryNoteController;
import com.incosyz.sms.dbcontroller.DeliveryNoteDBController;
import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.DeliveryOrderDetailModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Oct 28, 2015 Time : 3:18:02 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class DeliveryNoteControllerImpl extends UnicastRemoteObject implements DeliveryNoteController {

    public DeliveryNoteControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addDeliveryOrder(BatchModel batchModel) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.addBatchModel(batchModel);
    }

    @Override
    public ArrayList<BatchModel> getAllModel() throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.getAllModel();
    }

    @Override
    public boolean addDeliveryOrderDetail(DeliveryOrderDetailModel deliveryOrderDetailModel) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.addDeliveryOrderDetail(deliveryOrderDetailModel);
    }

    @Override
    public ArrayList<StockModel> getAllOrderDetail(String consignmentId) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.getAllOrderDetail(consignmentId);
    }

    @Override
    public boolean addColour(String colour) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.addColour(colour);
    }

    @Override
    public ArrayList<String> getColours() throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.getColours();
    }

    public ArrayList<BikeModel> getBikeModel(String modelId, String announcementId) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.getBikeModel(modelId, announcementId);
    }

    @Override
    public boolean updateDeliveryNote(BatchModel batchModel) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.updateDeliveryNote(batchModel);
    }

    @Override
    public boolean isExistRoundNo(String roundNo) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.isExistsRoundNo(roundNo);
    }

    @Override
    public boolean deleteDelivery(String consignmentNoteNo) throws ClassNotFoundException, SQLException, RemoteException {
        return DeliveryNoteDBController.deleteConsignment(consignmentNoteNo);
    }
}
