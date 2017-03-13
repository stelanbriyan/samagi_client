/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.DeliveryOrderDetailModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Date : Oct 28, 2015 Time : 3:21:37 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class DeliveryNoteDBController {

    public static boolean addBatchModel(BatchModel batchModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Batch VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, batchModel.getBatchId());
        stm.setString(2, batchModel.getConsignmentNoteNo());
        stm.setString(3, batchModel.getOrderRequestNo());
        stm.setString(4, batchModel.getTransportInvoiceNo());
        stm.setString(5, batchModel.getBatchDate());
        stm.setString(6, batchModel.getTransportOrderNo());
        stm.setString(7, batchModel.getNote());
        stm.setString(8, batchModel.getUserId());
        stm.setString(9, batchModel.getHelmet());
        stm.setString(10, batchModel.getWarrantyManual());
        stm.setString(11, batchModel.getSideMirror());
        stm.setString(12, batchModel.getJacket());
        stm.setString(13, batchModel.getToolKit());
        stm.setString(14, batchModel.getManual());
        stm.setString(15, batchModel.getContactNo());
        stm.setString(16, batchModel.getVehicleNo());
        stm.setString(17, batchModel.getDriverName());
        stm.setString(18, batchModel.getHelperName());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<BatchModel> getAllModel() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Batch";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet executeQuery = stm.executeQuery(sql);
        ArrayList<BatchModel> batchModels = new ArrayList<>();
        while (executeQuery.next()) {
            BatchModel batchModel = new BatchModel()
                    .setBatchId(executeQuery.getString(1))
                    .setConsignmentNoteNo(executeQuery.getString(2))
                    .setOrderRequestNo(executeQuery.getString(3))
                    .setTransportInvoiceNo(executeQuery.getString(4))
                    .setBatchDate(executeQuery.getString(5))
                    .setTransportOrderNo(executeQuery.getString(6))
                    .setNote(executeQuery.getString(7))
                    .setUserId(executeQuery.getString(8))
                    .setHelmet(executeQuery.getString(9))
                    .setWarrantyManual(executeQuery.getString(10))
                    .setSideMirror(executeQuery.getString(11))
                    .setJacket(executeQuery.getString(12))
                    .setToolKit(executeQuery.getString(13))
                    .setManual(executeQuery.getString(14))
                    .setContactNo(executeQuery.getString(15))
                    .setVehicleNo(executeQuery.getString(16))
                    .setDriverName(executeQuery.getString(17))
                    .setHelperName(executeQuery.getString(18));
            batchModels.add(batchModel);
        }
        return batchModels;
    }

    public static boolean addDeliveryOrderDetail(DeliveryOrderDetailModel deliveryOrderDetailModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Stock VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, deliveryOrderDetailModel.getBatchId());
        stm.setString(2, deliveryOrderDetailModel.getModelId());
        stm.setString(3, deliveryOrderDetailModel.getRoundNo());
        stm.setString(4, deliveryOrderDetailModel.getEngineNo());
        stm.setString(5, deliveryOrderDetailModel.getStateName());
        stm.setString(6, "0");
        stm.setString(7, deliveryOrderDetailModel.getRemark());
        stm.setString(8, deliveryOrderDetailModel.getChassisNo());
        stm.setString(9, deliveryOrderDetailModel.getNote());
        stm.setString(10, deliveryOrderDetailModel.getColour());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<StockModel> getAllOrderDetail(String batchId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId, Stock.modelId, modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo  , colour FROM Stock, Model WHERE Model.modelId = Stock.modelId AND batchId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, batchId);
        ResultSet resultSet = stm.executeQuery();
        ArrayList<StockModel> stockBikeModels = new ArrayList<>();
        while (resultSet.next()) {
            StockModel stockModel = new StockModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setColour(resultSet.getString(10));

            stockBikeModels.add(stockModel);
        }
        return stockBikeModels;
    }

    public static boolean addColour(String colour) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Colour(colourName) VALUES(?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, colour);
        int executeQuery = stm.executeUpdate();
        while (executeQuery > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getColours() throws ClassNotFoundException, SQLException {
        String sql = "SELECT colourName FROM Colour ORDER BY 1 DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();
        ArrayList<String> colours = new ArrayList<>();
        while (resultSet.next()) {
            colours.add(resultSet.getString(1));
        }
        return colours;
    }

    public static ArrayList<BikeModel> getBikeModel(String modelId, String announcementId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT bikeModelId , modelId , priceAnnouncementId , bikeOption , capacity , commision , netAmount , note , helmet , jacket FROM BikeModel WHERE priceAnnouncementId = ? AND modelId = ? ORDER BY 1 DESC LIMIT 1";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, announcementId);
        stm.setString(2, modelId);
        ResultSet resultSet = stm.executeQuery();
        ArrayList<BikeModel> bikeModels = new ArrayList<>();
        if (resultSet.next()) {
            BikeModel bikeModel = new BikeModel()
                    .setBikeModelId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setPriceAnnouncementId(resultSet.getString(3))
                    .setBikeOption(resultSet.getString(4))
                    .setCapacity(resultSet.getString(5))
                    .setCommision(resultSet.getString(6))
                    .setNetAmount(resultSet.getString(7))
                    .setNote(resultSet.getString(8))
                    .setHelmet(resultSet.getString(9))
                    .setJacket(resultSet.getString(10));
            bikeModels.add(bikeModel);
        }
        return bikeModels;
    }

    public static boolean updateDeliveryNote(BatchModel batchModel) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Batch SET consignmentNoteNo = ? , orderRequestNo = ? , transportInvoiceNo = ? , batchDate = ? , transportOrderNo = ? , note = ? , userId = ? , helmet = ? , warrantyManual = ? , sideMirror = ? , jacket = ? , toolKit = ? , manual = ? , contactNo = ? ,vehicleNo = ? , driverName = ? , helperName = ? WHERE batchId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, batchModel.getConsignmentNoteNo());
        stm.setString(2, batchModel.getOrderRequestNo());
        stm.setString(3, batchModel.getTransportInvoiceNo());
        stm.setString(4, batchModel.getBatchDate());
        stm.setString(5, batchModel.getTransportOrderNo());
        stm.setString(6, batchModel.getNote());
        stm.setString(7, batchModel.getUserId());
        stm.setString(8, batchModel.getHelmet());
        stm.setString(9, batchModel.getWarrantyManual());
        stm.setString(10, batchModel.getSideMirror());
        stm.setString(11, batchModel.getJacket());
        stm.setString(12, batchModel.getToolKit());
        stm.setString(13, batchModel.getManual());
        stm.setString(14, batchModel.getContactNo());
        stm.setString(15, batchModel.getVehicleNo());
        stm.setString(16, batchModel.getDriverName());
        stm.setString(17, batchModel.getHelperName());
        stm.setString(18, batchModel.getBatchId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean isExistsRoundNo(String roundNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Stock WHERE roundNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, roundNo);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

    public static boolean deleteConsignment(String consignmentNoteNo) throws ClassNotFoundException, SQLException {
        System.out.println("A");
        String batchId = getBatchId(consignmentNoteNo);
        System.out.println(batchId + " B" );
        String sql = "DELETE FROM Batch WHERE consignmentNoteNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, consignmentNoteNo);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            boolean deleteStockConsignment = deleteStockConsignment(batchId);
            return true;
        }
        return false;
    }
    
    public static String getBatchId(String constingmentNo) throws ClassNotFoundException, SQLException{
        System.out.println(constingmentNo);
        String sql = "SELECT batchId FROM Batch WHERE consignmentNoteNo ='" + constingmentNo + "'";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement createStatement = con.createStatement();
        ResultSet executeQuery = createStatement.executeQuery(sql);
        if (executeQuery.next()) {
            return executeQuery.getString(1);
        }
        return "";
    }

    public static boolean deleteStockConsignment(String consignmentNoteNo) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Stock WHERE batchId = '" + consignmentNoteNo + "'";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement createStatement = con.createStatement();
        int executeUpdate = createStatement.executeUpdate(sql);
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

}
