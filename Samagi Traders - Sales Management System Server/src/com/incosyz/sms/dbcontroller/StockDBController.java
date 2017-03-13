/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.GETStock;
import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.ReturnModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 13, 2015 Time : 4:41:16 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class StockDBController {

    public static ArrayList<GETStock> getStock(String priceAnnouncementId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Stock WHERE roundNo NOT IN  ( SELECT roundNo FROM OrderTable) AND  roundNo NOT IN  ( SELECT roundNo FROM ReturnStock)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<GETStock> gETStocks = new ArrayList<>();
        while (executeQuery.next()) {
            String batchId = executeQuery.getString(1);
            String modelId = executeQuery.getString(2);
            String roundNo = executeQuery.getString(3);
            String engineNo = executeQuery.getString(4);
            String stateName = executeQuery.getString(5);
            String isSold = executeQuery.getString(6);
            String remark = executeQuery.getString(7);
            String chassisNo = executeQuery.getString(8);
            String note = executeQuery.getString(9);
            String colour = executeQuery.getString(10);

            StockModel stockModel = new StockModel()
                    .setBatchId(batchId)
                    .setModelId(modelId)
                    .setRoundNo(roundNo)
                    .setEngineNo(engineNo)
                    .setStateName(stateName)
                    .setIsSold(isSold)
                    .setRemark(remark)
                    .setChassisNo(chassisNo)
                    .setColour(colour);

            BikeModel bikeModel = getBikeModel(modelId, priceAnnouncementId, con);
            Model model = getModel(modelId, con);
            BatchModel batch = getBatch(batchId, con);

            GETStock gETStock = new GETStock()
                    .setStockModel(stockModel)
                    .setBikeModel(bikeModel)
                    .setModel(model)
                    .setBatchModel(batch);
            gETStocks.add(gETStock);
        }
        return gETStocks;
    }

    public static BikeModel getBikeModel(String modelId, String priceAnnouncementId, Connection con) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM BikeModel WHERE modelId = ? AND priceAnnouncementId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, modelId);
        stm.setString(2, priceAnnouncementId);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            BikeModel bikeModel = new BikeModel()
                    .setBikeModelId(executeQuery.getString(1))
                    .setModelId(executeQuery.getString(2))
                    .setPriceAnnouncementId(executeQuery.getString(3))
                    .setBikeOption(executeQuery.getString(4))
                    .setCapacity(executeQuery.getString(5))
                    .setCommision(executeQuery.getString(6))
                    .setNetAmount(executeQuery.getString(7))
                    .setNote(executeQuery.getString(8))
                    .setHelmet(executeQuery.getString(9))
                    .setJacket(executeQuery.getString(10));

            return bikeModel;
        }
        return null;
    }

    public static Model getModel(String modelId, Connection con) throws SQLException {
        String sql = "SELECT * FROM Model WHERE modelId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, modelId);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            Model m = new Model()
                    .setModelId(executeQuery.getString(1))
                    .setModelName(executeQuery.getString(2).toUpperCase());
            return m;
        }
        return null;
    }

    public static BatchModel getBatch(String batchId, Connection con) throws SQLException {
        String sql = "SELECT * FROM Batch WHERE batchId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, batchId);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
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

            return batchModel;
        }
        return null;
    }

    public static boolean addToReturn(ReturnModel model) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ReturnStock VALUES(?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, model.getReturnId());
        stm.setString(2, model.getRoundNo());
        stm.setString(3, model.getNote());
        stm.setString(4, model.getDate());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<GETStock> getReturnStock(String priceAnnouncementId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Stock , ReturnStock WHERE Stock.roundNo = ReturnStock.roundNo AND Stock.roundNo NOT IN ( SELECT roundNo FROM OrderTable)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<GETStock> gETStocks = new ArrayList<>();
        while (executeQuery.next()) {
            String batchId = executeQuery.getString(1);
            String modelId = executeQuery.getString(2);
            String roundNo = executeQuery.getString(3);
            String engineNo = executeQuery.getString(4);
            String stateName = executeQuery.getString(5);
            String isSold = executeQuery.getString(6);
            String remark = executeQuery.getString(7);
            String chassisNo = executeQuery.getString(8);
            String note = executeQuery.getString(9);
            String colour = executeQuery.getString(10);

            StockModel stockModel = new StockModel()
                    .setBatchId(batchId)
                    .setModelId(modelId)
                    .setRoundNo(roundNo)
                    .setEngineNo(engineNo)
                    .setStateName(stateName)
                    .setIsSold(isSold)
                    .setRemark(remark)
                    .setChassisNo(chassisNo)
                    .setColour(colour);

            BikeModel bikeModel = getBikeModel(modelId, priceAnnouncementId, con);
            Model model = getModel(modelId, con);
            BatchModel batch = getBatch(batchId, con);

            GETStock gETStock = new GETStock()
                    .setStockModel(stockModel)
                    .setBikeModel(bikeModel)
                    .setModel(model)
                    .setBatchModel(batch);
            gETStocks.add(gETStock);
        }
        return gETStocks;
    }

    public static boolean deleteStock(String text) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Stock WHERE roundNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, text);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }
}
