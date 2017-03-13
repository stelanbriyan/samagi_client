/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.PriceAnnouncementController;
import com.incosyz.sms.dbcontroller.PriceAnnoucementDBController;
import com.incosyz.sms.mixmodel.BikeSpecialDealerModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PriceAnnouncementModel;
import com.incosyz.sms.model.SpecialDealerModel;
import com.incosyz.sms.other.IDGenerator;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stelan
 */
public class PriceAnnouncementControllerImpl extends UnicastRemoteObject implements PriceAnnouncementController {

    public PriceAnnouncementControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addOption(String option) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.addBikeOption(option);
    }

    @Override
    public boolean addPriceAnnouncement(PriceAnnouncementModel priceAnnouncementModel) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.addPriceAnnouncement(priceAnnouncementModel);
    }

    @Override
    public String getId(String tableName, String columnName, String prefix, int digitCount) throws RemoteException, ClassNotFoundException, SQLException {
        return IDGenerator.getNewId(tableName, columnName, prefix, digitCount);
    }

    @Override
    public ArrayList<PriceAnnouncementModel> getAllPriceAnnouncement() throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getAllPriceAnnouncement();
    }

    @Override
    public ArrayList<String> getOption() throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getOption();
    }

    @Override
    public String getFinalModelId() throws RemoteException, ClassNotFoundException, SQLException {
        return IDGenerator.getNewId("BikeModel", "modelId", "M", 3);
    }

    @Override
    public boolean addBikeModel(BikeModel bikeModel) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.addBikeModel(bikeModel);
    }

    @Override
    public ArrayList<Model> getAllModelName() throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getAllModel();
    }

    @Override
    public ArrayList<BikeModel> getAllBikeModel(String priceAnnouncementId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getAllBikeModel(priceAnnouncementId);
    }

    @Override
    public boolean addSpecialDealerModel(SpecialDealerModel specialDealerModel) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.addSpecialDealerModel(specialDealerModel);
    }

    @Override
    public ArrayList<BikeSpecialDealerModel> getAllSpecialDealerDetail(String annoucementId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getAllSpecialDealerDetail(annoucementId);
    }

    @Override
    public boolean addModel(String modelId, String modelName) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.addModel(modelId, modelName);
    }

    @Override
    public ArrayList<String> getModel() throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getModel();
    }

    public ArrayList<Model> getAnnouncementsModel(String announcementId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getAnnouncementsModel(announcementId);
    }

    @Override
    public ArrayList<OrderModel> getOrders(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getOrders(bikeModelId);
    }

    @Override
    public ArrayList<SpecialDealerModel> getHtc(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getHtc(bikeModelId);
    }

    @Override
    public boolean deleteItem(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.deleteBikeModel(bikeModelId);
    }

    @Override
    public boolean updateBikeModel(BikeModel bikeModel) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.updateBikeModel(bikeModel);
    }

    @Override
    public boolean getIsExistsModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.isExistsModel(modelId);
    }

    @Override
    public boolean deleteModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.deleteModel(modelId);
    }

    @Override
    public String getModelId(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.getModelId(selectedValue);
    }

    @Override
    public boolean deleteOption(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.deleteOption(selectedValue);
    }

    @Override
    public boolean deleteHtc(String specialDealerId) throws RemoteException, ClassNotFoundException, SQLException {
        return PriceAnnoucementDBController.deleteHtc(specialDealerId);
    }
}
