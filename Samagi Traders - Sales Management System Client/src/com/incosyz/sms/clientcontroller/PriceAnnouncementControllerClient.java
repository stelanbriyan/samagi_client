/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.mixmodel.BikeSpecialDealerModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PriceAnnouncementModel;
import com.incosyz.sms.model.SpecialDealerModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stelan
 */
public class PriceAnnouncementControllerClient {

    public static boolean addBikeModel(BikeModel bikeModel) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        boolean addBikeModel = ServerConnector.getServerConnector()
                .getPriceAnnouncementController().addBikeModel(bikeModel);
        return addBikeModel;
    }

    public static boolean addModel(String modelId, String modelName) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().addModel(modelId, modelName);
    }

    public static ArrayList<String> getModel() throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getModel();
    }

    public static boolean addPriceAnnouncement(PriceAnnouncementModel priceAnnouncementModel) throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        boolean addPriceAnnouncement = ServerConnector.getServerConnector()
                .getPriceAnnouncementController().addPriceAnnouncement(priceAnnouncementModel);
        return addPriceAnnouncement;
    }

    public static boolean isPriceAnnouncementExists() {
        return true;
    }

    public static ArrayList<PriceAnnouncementModel> getPriceAnnouncement() throws NotBoundException, MalformedURLException, RemoteException, ClassNotFoundException, SQLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getAllPriceAnnouncement();
    }

    public static boolean addOption(String option) throws NotBoundException, NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().addOption(option);
    }

    public static ArrayList<String> getOption() throws NotBoundException, NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getOption();
    }

    public static String getModelId() throws NotBoundException, NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getFinalModelId();
    }

    public static ArrayList<Model> getAllModelName() throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getAllModelName();
    }

    public static ArrayList<BikeModel> getAllBikeModel(String priceAnnouncementId) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getAllBikeModel(priceAnnouncementId);
    }

    public static boolean addSpecialDealerModel(SpecialDealerModel specialDealerModel) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().addSpecialDealerModel(specialDealerModel);
    }

    public static ArrayList<BikeSpecialDealerModel> getAllSpecialDealerModel(String announcementId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getAllSpecialDealerDetail(announcementId);
    }

    public static ArrayList<Model> getAnnouncementsModel(String announcementId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getAnnouncementsModel(announcementId);
    }

    public static ArrayList<OrderModel> getOrders(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getOrders(bikeModelId);
    }

    public static ArrayList<SpecialDealerModel> getHtc(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getHtc(bikeModelId);
    }

    public static boolean deletePriceAnnouncementId(String bikeModelId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().deleteItem(bikeModelId);
    }

    public static boolean updateBikeModel(BikeModel bikeModel) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().updateBikeModel(bikeModel);
    }

    public static String getModelId(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getModelId(selectedValue);
    }

    public static boolean isExistsModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().getIsExistsModel(modelId);
    }

    public static boolean deleteModel(String modelId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().deleteModel(modelId);
    }

    public static boolean deleteOption(String selectedValue) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().deleteOption(selectedValue);
    }

    public static boolean deleteHTC(String specialDealerId) throws RemoteException, ClassNotFoundException, SQLException, NotBoundException, MalformedURLException {
        return ServerConnector.getServerConnector().getPriceAnnouncementController().deleteHtc(specialDealerId);
    }

}
