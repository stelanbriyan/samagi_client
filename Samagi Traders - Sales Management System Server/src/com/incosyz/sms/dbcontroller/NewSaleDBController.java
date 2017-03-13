/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.SaleBikeDetailModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.NoteTableModel;
import com.incosyz.sms.model.SpecialDealerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Date : Nov 1, 2015 Time : 4:54:45 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class NewSaleDBController {

    public static ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail() throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock)  ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleBikeDetail(String roundNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND isSold='0' AND roundNo LIKE '%" + roundNo + "%'  AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock) ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailModelName(String modelName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND isSold='0' AND modelName LIKE '%" + modelName + "%'  AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock) ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailColour(String colour) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND isSold='0' AND colour LIKE '%" + colour + "%'  AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock) ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static ArrayList<SaleBikeDetailModel> getAllSaleBikeDetailChassis(String chassisNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND isSold='0' AND chassisNo LIKE '%" + chassisNo + "%'  AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock) ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static SpecialDealerModel getSpecialConsignmentDealer(String bikeModel) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM ConsignmentDealer WHERE bikeModelId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bikeModel);
        ResultSet resultSet = stm.executeQuery();
        if (resultSet.next()) {
            SpecialDealerModel specialDealerModel = new SpecialDealerModel()
                    .setSpecialDealerId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setSpecialPrice(resultSet.getString(3))
                    .setDealerMargine(resultSet.getString(4));
            return specialDealerModel;
        }
        return null;
    }

    public static void updateIsSold(int isSold) {

    }

    public static CheckModel getCheque(String chequeNumber) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Cheque WHERE checkNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, chequeNumber);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            CheckModel checkModel = new CheckModel()
                    .setChequeId(executeQuery.getString(1))
                    .setPaymentId(executeQuery.getString(2))
                    .setCheckNo(executeQuery.getString(3))
                    .setBankName(executeQuery.getString(4))
                    .setChequeDate(executeQuery.getString(5))
                    .setAmount(executeQuery.getString(6))
                    .setStateName(executeQuery.getString(7))
                    .setIssuedBy(executeQuery.getString(8))
                    .setType(executeQuery.getString(9))
                    .setAccountNo(executeQuery.getString(10))
                    .setNote(executeQuery.getString(11))
                    .setIsIssued(executeQuery.getString(12));
            return checkModel;
        }
        return null;
    }

    public static ArrayList<SaleBikeDetailModel> getEngine(String text) throws ClassNotFoundException, SQLException {
        String sql = "SELECT batchId , Stock.modelId , modelName , roundNo , engineNo , stateName , isSold , remark , chassisNo , note , colour  FROM Stock , Model WHERE Model.modelId = Stock.modelId AND isSold='0' AND engineNo LIKE '%" + text + "%'  AND roundNo NOT IN ( SELECT roundNo FROM OrderTable) AND roundNo NOT IN  ( SELECT roundNo FROM ReturnStock) ORDER BY modelName DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        ArrayList<SaleBikeDetailModel> saleBikeDetailModels = new ArrayList<>();
        while (resultSet.next()) {
            SaleBikeDetailModel bikeDetailModel = new SaleBikeDetailModel()
                    .setBatchId(resultSet.getString(1))
                    .setModelId(resultSet.getString(2))
                    .setModelName(resultSet.getString(3))
                    .setRoundNo(resultSet.getString(4))
                    .setEngineNo(resultSet.getString(5))
                    .setStateName(resultSet.getString(6))
                    .setIsSold(resultSet.getString(7))
                    .setRemark(resultSet.getString(8))
                    .setChassisNo(resultSet.getString(9))
                    .setNote(resultSet.getString(10))
                    .setColour(resultSet.getString(11));
            saleBikeDetailModels.add(bikeDetailModel);
        }
        return saleBikeDetailModels;
    }

    public static boolean saveNote(String orderId, String note) throws SQLException, ClassNotFoundException {
        if (isNote(orderId)) {
            String sql = "UPDATE NoteTableOrder SET note = ? WHERE orderId = ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, note);
            prepareStatement.setString(2, orderId);
            int executeUpdate = prepareStatement.executeUpdate();
            return executeUpdate > 0;
        } else {
            String sql = "INSERT INTO NoteTableOrder(orderId ,note , isReport ) VALUES(?,?,?)";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, orderId);
            prepareStatement.setString(2, note);
            prepareStatement.setString(3, "");
            int executeUpdate = prepareStatement.executeUpdate();
            return executeUpdate > 0;
        }
    }

    public static boolean isNote(String orderId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM NoteTableOrder WHERE orderId = '" + orderId + "'";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement createStatement = con.createStatement();
        ResultSet executeQuery = createStatement.executeQuery(sql);
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

    public static NoteTableModel getNoteTableModel(String orderId) throws SQLException, ClassNotFoundException {
        System.out.println("A");
        String sql = "SELECT * FROM NoteTableOrder WHERE orderId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, orderId);
        ResultSet executeQuery = preparedStatement.executeQuery();
        if (executeQuery.next()) {
            NoteTableModel noteTableModel = new NoteTableModel();
            noteTableModel.setOrderId(executeQuery.getString(1));
            noteTableModel.setNoteTableId(executeQuery.getString(2));
            noteTableModel.setNote(executeQuery.getString(3));
            noteTableModel.setIsReport(executeQuery.getString(4));

            return noteTableModel;
        }
        return null;
    }

    public static void report(String orderId) throws SQLException, ClassNotFoundException {
        if (isNote(orderId)) {
            String sql = "UPDATE NoteTableOrder SET isReport = ? WHERE orderId = ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, "1");
            prepareStatement.setString(2, orderId);
            int executeUpdate = prepareStatement.executeUpdate();
//            return executeUpdate > 0;
        } else {
            String sql = "INSERT INTO NoteTableOrder(orderId ,note , isReport ) VALUES(?,?,?)";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, orderId);
            prepareStatement.setString(2, "");
            prepareStatement.setString(3, "1");
            int executeUpdate = prepareStatement.executeUpdate();
//            return executeUpdate > 0;
        }
    }

    public static boolean deleteSale(String roundNo) throws ClassNotFoundException, SQLException {
        removeCheque(roundNo);
        removeCash(roundNo);
        String sql = "DELETE FROM OrderTable WHERE roundNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, roundNo);
        int executeUpdate = stm.executeUpdate();
        return executeUpdate > 0;
    }
    
    private static void removeCheque(String roundNo) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM cheque WHERE paymentId IN (SELECT paymentId FROM ordertable WHERE roundNo = ?) ";
                Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, roundNo);
        int executeUpdate = stm.executeUpdate();
    }
    
    private static void removeCash(String roundNo) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM cash WHERE paymentId IN (SELECT paymentId FROM ordertable WHERE roundNo = ?) ";
                Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, roundNo);
        int executeUpdate = stm.executeUpdate();
    }
}
