/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.BikeSpecialDealerModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PriceAnnouncementModel;
import com.incosyz.sms.model.SpecialDealerModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stelan
 */
public interface PriceAnnouncementController extends Remote {

    public boolean addModel(String modelId, String modelName) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<String> getModel() throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addBikeModel(BikeModel bikeModel) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addPriceAnnouncement(PriceAnnouncementModel priceAnnouncementModel) throws RemoteException, ClassNotFoundException, SQLException;

    public String getId(String tableName, String columnName, String prefix, int digitCount) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<PriceAnnouncementModel> getAllPriceAnnouncement() throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addOption(String option) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<String> getOption() throws RemoteException, ClassNotFoundException, SQLException;

    public String getFinalModelId() throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<Model> getAllModelName() throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<BikeModel> getAllBikeModel(String priceAnnouncementId) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean addSpecialDealerModel(SpecialDealerModel specialDealerModel) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<BikeSpecialDealerModel> getAllSpecialDealerDetail(String annoucementId) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<Model> getAnnouncementsModel(String announcementId) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<OrderModel> getOrders(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException;

    public ArrayList<SpecialDealerModel> getHtc(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteItem(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean updateBikeModel(BikeModel bikeModel) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean getIsExistsModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException;

    public String getModelId(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteOption(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException;

    public boolean deleteHtc(String specialDealerId) throws RemoteException, ClassNotFoundException, SQLException;
}
