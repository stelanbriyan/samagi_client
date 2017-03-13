/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.BikeSpecialDealerModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PriceAnnouncementModel;
import com.incosyz.sms.model.SpecialDealerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Date : Oct 27, 2015 Time : 7:31:30 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
/**
 * Table : PriceAnnouncement , BikeOption Do all works in price Announcement.
 *
 * @author Stelan
 */
public class PriceAnnoucementDBController {

    /**
     *
     * @param priceAnnouncementModel
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static boolean addPriceAnnouncement(PriceAnnouncementModel priceAnnouncementModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO PriceAnnouncement VALUES(?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, priceAnnouncementModel.getPriceAnnouncementId());
        stm.setString(2, priceAnnouncementModel.getPriceAnnouncementDate());
        stm.setString(3, priceAnnouncementModel.getEffectDate());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<PriceAnnouncementModel> getAllPriceAnnouncement() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM PriceAnnouncement ORDER BY 2 DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ArrayList<PriceAnnouncementModel> priceAnnouncementModels = new ArrayList<>();
        ResultSet executeQuery = stm.executeQuery(sql);
        while (executeQuery.next()) {
            PriceAnnouncementModel priceAnnouncementModel = new PriceAnnouncementModel()
                    .setPriceAnnouncementId(executeQuery.getString(1))
                    .setPriceAnnouncementDate(executeQuery.getString(2))
                    .setEffectDate(executeQuery.getString(3));
            priceAnnouncementModels.add(priceAnnouncementModel);
        }
        return priceAnnouncementModels;
    }

    public static boolean addBikeOption(String option) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO BikeOption(optionName) VALUES(?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, option.toUpperCase());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getOption() throws ClassNotFoundException, SQLException {
        String sql = "SELECT optionName FROM BikeOption";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet executeQuery = stm.executeQuery(sql);
        ArrayList<String> options = new ArrayList<>();
        while (executeQuery.next()) {
            options.add(executeQuery.getString(1));
        }
        return options;
    }

    public static boolean addBikeModel(BikeModel bikeModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO BikeModel VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModel.getBikeModelId());
        stm.setString(2, bikeModel.getModelId());
        stm.setString(3, bikeModel.getPriceAnnouncementId());
        stm.setString(4, bikeModel.getBikeOption());
        stm.setString(5, bikeModel.getCapacity());
        stm.setString(6, bikeModel.getCommision());
        stm.setString(7, bikeModel.getNetAmount());
        stm.setString(8, bikeModel.getNote());
        stm.setString(9, bikeModel.getHelmet());
        stm.setString(10, bikeModel.getJacket());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<BikeModel> getAllBikeModel(String priceAnnouncementId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT bikeModelId , BikeModel.modelId , priceAnnouncementId , modelName , bikeOption , capacity , commision , netAmount , note , helmet , jacket FROM BikeModel , Model WHERE Model.modelId = BikeModel.modelId AND priceAnnouncementId=? GROUP BY modelName";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, priceAnnouncementId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<BikeModel> bikeModels = new ArrayList<>();
        while (executeQuery.next()) {
            BikeModel bikeModel = new BikeModel()
                    .setBikeModelId(executeQuery.getString(1))
                    .setModelId(executeQuery.getString(2))
                    .setPriceAnnouncementId(executeQuery.getString(3))
                    .setModelName(executeQuery.getString(4))
                    .setBikeOption(executeQuery.getString(5))
                    .setCapacity(executeQuery.getString(6))
                    .setCommision(executeQuery.getString(7))
                    .setNetAmount(executeQuery.getString(8))
                    .setNote(executeQuery.getString(9))
                    .setHelmet(executeQuery.getString(10))
                    .setJacket(executeQuery.getString(11));
            bikeModels.add(bikeModel);
        }
        return bikeModels;
    }

    public static ArrayList<Model> getAllModel() throws ClassNotFoundException, SQLException {
        String sql = "SELECT modelId , modelName FROM Model";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery(sql);
        ArrayList<Model> models = new ArrayList<>();
        while (executeQuery.next()) {
            Model model = new Model().setModelId(executeQuery.getString(1)).setModelName(executeQuery.getString(2));
            models.add(model);
        }
        return models;
    }

    public static boolean addSpecialDealerModel(SpecialDealerModel specialDealerModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO ConsignmentDealer VALUES(?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, specialDealerModel.getSpecialDealerId());
        stm.setString(2, specialDealerModel.getModelId());
        stm.setString(3, specialDealerModel.getSpecialPrice());
        stm.setString(4, specialDealerModel.getDealerMargine());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<BikeSpecialDealerModel> getAllSpecialDealerDetail(String announcement) throws ClassNotFoundException, SQLException {
        String sql = "SELECT priceAnnouncementId, specialDealerId ,ConsignmentDealer.bikeModelId , specialPrice , dealerMargine , modelName , capacity , netAmount FROM ConsignmentDealer , BikeModel, Model WHERE ConsignmentDealer.bikeModelId =  BikeModel.bikeModelId AND Model.modelId = BikeModel.modelId AND priceAnnouncementId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, announcement);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<BikeSpecialDealerModel> bikeSpecialDealerModels = new ArrayList<>();
        while (executeQuery.next()) {
            System.out.println(executeQuery.getString(6));
            BikeSpecialDealerModel bikeSpecialDealerModel = new BikeSpecialDealerModel();
            bikeSpecialDealerModel.setPriceAnnouncementId(executeQuery.getString(1));
            bikeSpecialDealerModel.setSpecialDealerId(executeQuery.getString(2));
            bikeSpecialDealerModel.setModelId(executeQuery.getString(3));
            bikeSpecialDealerModel.setSpecialPrice(executeQuery.getString(4));
            bikeSpecialDealerModel.setDealerMargine(executeQuery.getString(5));
            bikeSpecialDealerModel.setModelName(executeQuery.getString(6));
            bikeSpecialDealerModel.setCapacity(executeQuery.getString(7));
            bikeSpecialDealerModel.setNetAmount(executeQuery.getString(8));
            bikeSpecialDealerModels.add(bikeSpecialDealerModel);
        }
        return bikeSpecialDealerModels;
    }

    public static boolean addModel(String modelId, String modelName) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Model VALUES(?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, modelId);
        stm.setString(2, modelName.toUpperCase());
        int execute = stm.executeUpdate();
        if (execute > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getModel() throws ClassNotFoundException, SQLException {
        String sql = "SELECT modelName FROM Model ORDER BY 1 DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();
        ArrayList<String> models = new ArrayList<>();
        while (resultSet.next()) {
            models.add(resultSet.getString(1));
        }
        return models;
    }

    public static ArrayList<Model> getAnnouncementsModel(String announcementId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT BikeModel.modelId ,modelName ,priceAnnouncementId FROM Model , BikeModel WHERE Model.modelId = BikeModel.modelId AND priceAnnouncementId=? GROUP BY 2";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, announcementId);
        ResultSet resultSet = stm.executeQuery();
        ArrayList<Model> models = new ArrayList<>();
        while (resultSet.next()) {
            Model model = new Model().setModelId(resultSet.getString(1)).setModelName(resultSet.getString(2));
            models.add(model);
        }
        return models;
    }

    public static ArrayList<OrderModel> getOrders(String bikeModelId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM OrderTable WHERE bikeModelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModelId);
        System.out.println(bikeModelId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<OrderModel> al = new ArrayList<>();
        while (executeQuery.next()) {
            String customerId = executeQuery.getString(4);
            CustomerModel customer = OrderDBController.getCustomer(customerId, con);
            OrderModel model = new OrderModel()
                    .setOrderId(executeQuery.getString(1))
                    .setRoundNo(executeQuery.getString(2))
                    .setCustomerId(customer.getCustomerName())
                    .setOrderAmount(executeQuery.getString(11));
            al.add(model);
        }
        return al;
    }

    public static ArrayList<SpecialDealerModel> getHtc(String bikeModelId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM consignmentDealer WHERE bikeModelId= ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModelId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<SpecialDealerModel> specialDealerModels = new ArrayList<>();
        while (executeQuery.next()) {
            SpecialDealerModel dealerModel = new SpecialDealerModel();
            dealerModel.setSpecialDealerId(executeQuery.getString(1));
            dealerModel.setModelId(executeQuery.getString(2));
            dealerModel.setSpecialPrice(executeQuery.getString(3));
            dealerModel.setDealerMargine(executeQuery.getString(4));
            specialDealerModels.add(dealerModel);
        }
        return specialDealerModels;
    }

    public static boolean deleteBikeModel(String bikeModelId) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM BikeModel WHERE bikeModelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModelId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateBikeModel(BikeModel bikeModel) throws ClassNotFoundException, SQLException {
        String sql = "Update BikeModel SET bikeOption = ? , capacity = ? , commision = ? , netAmount = ? , helmet = ? , jacket = ? WHERE bikeModelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModel.getBikeOption());
        stm.setString(2, bikeModel.getCapacity());
        stm.setString(3, bikeModel.getCommision());
        stm.setString(4, bikeModel.getNetAmount());
        stm.setString(5, bikeModel.getHelmet());
        stm.setString(6, bikeModel.getJacket());
        stm.setString(7, bikeModel.getBikeModelId());
        System.out.println(bikeModel.getBikeModelId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean isExistsModel(String modelId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM BikeModel WHERE modelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, modelId);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

    public static boolean deleteModel(String modelId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Model WHERE modelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, modelId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static String getModelId(String selectedValue) throws ClassNotFoundException, SQLException {
        String sql = "SELECT modelId FROM Model WHERE modelName = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, selectedValue);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            return executeQuery.getString(1);
        }
        return "";
    }

    public static boolean deleteOption(String selectedValue) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM BikeOption WHERE optionName = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, selectedValue);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean deleteHtc(String specialDealerId) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM ConsignmentDealer WHERE specialDealerId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, specialDealerId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

}
