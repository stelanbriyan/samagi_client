/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.DeliveryOrderDetailModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Oct 28, 2015 Time : 4:33:22 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class DeliveryNoteControllerClient {

    public static boolean addDeliveryNote(BatchModel batchModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().addDeliveryOrder(batchModel);
    }

    public static ArrayList<BatchModel> getAllBatch() throws ClassNotFoundException, SQLException, NotBoundException, MalformedURLException, RemoteException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().getAllModel();
    }

    public static boolean addDeliveryOrderDetail(DeliveryOrderDetailModel deliveryOrderDetailModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().addDeliveryOrderDetail(deliveryOrderDetailModel);
    }

    public static ArrayList<StockModel> getAllOrderDetail(String consignmentId) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().getAllOrderDetail(consignmentId);
    }

    public static boolean addColour(String colourName) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().addColour(colourName);
    }

    public static ArrayList<String> getColours() throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().getColours();
    }

    public static ArrayList<BikeModel> getBikeModel(String modelId, String announcementId) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().getBikeModel(modelId, announcementId);
    }

    public static boolean updateDeliveryNote(BatchModel batchModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().updateDeliveryNote(batchModel);
    }

    public static boolean isExistsRoundNo(String roundNo) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().isExistRoundNo(roundNo);
    }

    public static boolean deleteDelivery(String consignmentNoteNo) throws NotBoundException, MalformedURLException, ClassNotFoundException, RemoteException, SQLException {
        return ServerConnector.getServerConnector().getDeliveryNoteController().deleteDelivery(consignmentNoteNo);
    }
}
