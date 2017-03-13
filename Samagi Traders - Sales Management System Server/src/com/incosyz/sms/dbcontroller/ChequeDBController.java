/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.other.IDGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Date : Nov 11, 2015 Time : 11:52:43 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ChequeDBController {

    public static ArrayList<CheckModel> getCheque() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Cheque ORDER BY chequeDate DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<CheckModel> checkModels = new ArrayList<>();
        while (executeQuery.next()) {
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

            checkModels.add(checkModel);
        }
        return checkModels;
    }

    public static boolean addCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Cheque VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, checkModel.getChequeId());
        stm.setString(2, checkModel.getPaymentId());
        stm.setString(3, checkModel.getCheckNo());
        stm.setString(4, checkModel.getBankName());
        stm.setString(5, checkModel.getChequeDate());
        stm.setString(6, checkModel.getAmount());
        stm.setString(7, checkModel.getStateName());
        stm.setString(8, checkModel.getIssuedBy());
        stm.setString(9, checkModel.getType());
        stm.setString(10, checkModel.getAccountNo());
        stm.setString(11, checkModel.getNote());
        stm.setString(12, checkModel.getIsIssued());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateCheque(CheckModel checkModel) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Cheque SET bankName = ? , chequeDate = ? , amount = ? , stateName = ? , issuedBy = ?, chequeType = ?, accountNo = ?, note = ? , isIssued = ?  WHERE chequeId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, checkModel.getBankName());
        stm.setString(2, checkModel.getChequeDate());
        stm.setString(3, checkModel.getAmount());
        stm.setString(4, checkModel.getStateName());
        stm.setString(5, checkModel.getIssuedBy());
        stm.setString(6, checkModel.getType());
        stm.setString(7, checkModel.getAccountNo());
        stm.setString(8, checkModel.getNote());
        stm.setString(9, checkModel.getIsIssued());
        stm.setString(10, checkModel.getChequeId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean deleteCheque(String chequeId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Cheque WHERE chequeId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, chequeId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean stateChange(String state, String chequeId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Cheque SET stateName = ? WHERE chequeId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, state);
        stm.setString(2, chequeId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<CheckModel> getCheque(String paymentId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Cheque WHERE paymentId = ? ORDER BY chequeDate DESC";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, paymentId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<CheckModel> checkModels = new ArrayList<>();
        while (executeQuery.next()) {
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

            checkModels.add(checkModel);
        }
        return checkModels;
    }

    public static ArrayList<CheckModel> getTodayCheque() throws ClassNotFoundException, SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());

        String sql = "SELECT * FROM Cheque WHERE chequeDate < '" + format + "' AND stateName = ''";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<CheckModel> checkModels = new ArrayList<>();
        while (executeQuery.next()) {
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

            checkModels.add(checkModel);
        }
        return checkModels;
    }

    public static boolean isExists(String chequeNo1) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Cheque WHERE checkNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, chequeNo1);
        ResultSet executeQuery = prepareStatement.executeQuery();
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

}
