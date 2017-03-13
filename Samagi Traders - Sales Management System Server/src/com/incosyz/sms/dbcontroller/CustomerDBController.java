/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.CRNPlateInfo;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.LeasingModel;
import com.incosyz.sms.model.MobileModel;
import com.incosyz.sms.model.RmvModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Date : Nov 6, 2015 Time : 6:11:42 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CustomerDBController {

    public static boolean addCustomer(CustomerModel customerModel, Connection con) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, customerModel.getCustomerId());
        preparedStatement.setString(2, customerModel.getCustomerName());
        preparedStatement.setString(3, customerModel.getNicNo());
        preparedStatement.setString(4, customerModel.getAddressLineOne());
        preparedStatement.setString(5, customerModel.getAddressLineTwo());
        preparedStatement.setString(6, customerModel.getAddressLineThree());
        int execute = preparedStatement.executeUpdate();
        if (execute > 0) {
            return true;
        }
        return false;
    }

    public static boolean addMobile(ArrayList<MobileModel> mobileModels, Connection con) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Mobile(customerId,mobileNo) VALUES(?,?)";
        if (mobileModels == null) {
            return true;
        }
        for (MobileModel mobileModel : mobileModels) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, mobileModel.getCustomerId());
            preparedStatement.setString(2, mobileModel.getMobileNo());
            int execute = preparedStatement.executeUpdate();
        }
        return true;
    }

    public static boolean addHomePhone(ArrayList<HomePhoneModel> homePhoneModels, Connection con) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO HomePhone(customerId,homePhoneNo) VALUES(?,?)";
        if (homePhoneModels == null) {
            return true;
        }
        for (HomePhoneModel homePhoneModel : homePhoneModels) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, homePhoneModel.getCustomerId());
            preparedStatement.setString(2, homePhoneModel.getHomePhoneNo());
            int execute = preparedStatement.executeUpdate();
        }
        return true;
    }

    public static CustomerModel getCustomer(String nic) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Customer WHERE nic=?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, nic);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            CustomerModel customerModel = new CustomerModel()
                    .setCustomerId(executeQuery.getString(1))
                    .setCustomerName(executeQuery.getString(2))
                    .setNicNo(executeQuery.getString(3))
                    .setAddressLineOne(executeQuery.getString(4))
                    .setAddressLineTwo(executeQuery.getString(5))
                    .setAddressLineThree(executeQuery.getString(6));
            return customerModel;
        }
        return null;
    }

    public static ArrayList<MobileModel> getMobile(String customerId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Mobile WHERE customerId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, customerId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<MobileModel> mobileModels = new ArrayList<>();
        while (executeQuery.next()) {
            MobileModel mobileModel = new MobileModel()
                    .setMobileId(executeQuery.getString(1))
                    .setCustomerId(executeQuery.getString(2))
                    .setMobileNo(executeQuery.getString(3));
            mobileModels.add(mobileModel);
        }
        return mobileModels;
    }

    public static ArrayList<HomePhoneModel> getHomePhone(String customerId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM HomePhone WHERE customerId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, customerId);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<HomePhoneModel> homePhoneModels = new ArrayList<>();
        while (executeQuery.next()) {
            HomePhoneModel mobileModel = new HomePhoneModel()
                    .setHomePhoneId(executeQuery.getString(1))
                    .setCustomerId(executeQuery.getString(2))
                    .setHomePhoneNo(executeQuery.getString(3));
            homePhoneModels.add(mobileModel);
        }
        return homePhoneModels;
    }

    public static boolean isExistCustomer(String nic) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Customer WHERE nic=?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, nic);
        ResultSet executeQuery = stm.executeQuery();
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

    public static boolean updateCustomer(CustomerModel customerModel) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Customer SET customerId = ? , customerName = ? , addressLine1 = ? , addressLine2 = ? , addressLine3 = ? WHERE nic = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, customerModel.getCustomerId());
        stm.setString(2, customerModel.getCustomerName());
        stm.setString(3, customerModel.getAddressLineOne());
        stm.setString(4, customerModel.getAddressLineTwo());
        stm.setString(5, customerModel.getAddressLineThree());
        stm.setString(6, customerModel.getNicNo());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateCustomerDetail(CustomerModel customerModel) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Customer SET  customerName = ? ,nic = ?, addressLine1 = ? , addressLine2 = ? , addressLine3 = ?  WHERE customerId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, customerModel.getCustomerName());
        stm.setString(2, customerModel.getNicNo());
        stm.setString(3, customerModel.getAddressLineOne());
        stm.setString(4, customerModel.getAddressLineTwo());
        stm.setString(5, customerModel.getAddressLineThree());
        stm.setString(6, customerModel.getCustomerId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateMobile(ArrayList<MobileModel> mobiles) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Mobile SET mobileNo = ? WHERE mobileId = ?";
        int count = 0;
        for (MobileModel mobileModel : mobiles) {
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, mobileModel.getMobileNo());
            stm.setString(2, mobileModel.getMobileId());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                count += 1;
            }
        }
        if (mobiles.size() == count) {
            return true;
        }
        return false;
    }

    public static boolean updateHomePhone(ArrayList<HomePhoneModel> homePhoneModels) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE HomePhone SET homePhoneNo = ? WHERE homePhoneId = ?";
        int count = 0;
        for (HomePhoneModel homePhoneModel : homePhoneModels) {
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, homePhoneModel.getHomePhoneNo());
            stm.setString(2, homePhoneModel.getHomePhoneId());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                count += 1;
            }
        }
        if (homePhoneModels.size() == count) {
            return true;
        }
        return false;
    }

    public static boolean addCash(CashModel cashModel) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Cash VALUES(?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, cashModel.getCashId());
        stm.setString(2, cashModel.getPaymentId());
        stm.setString(3, cashModel.getCashAmount());
        stm.setString(4, cashModel.getCashDate());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateLeasing(LeasingModel leasingModel) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Leasing SET mta = ? , mta2 = ? , mta3 = ? , do = ? , do2 = ? , idCopy =  ?, gs = ? , gap = ? , garanter = ?, leasingName = ? , idPhoto = ? , snCharge = ? WHERE leasingId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, leasingModel.getMta());
        stm.setString(2, leasingModel.getMta2());
        stm.setString(3, leasingModel.getMta3());
        stm.setString(4, leasingModel.getDoNo());
        stm.setString(5, leasingModel.getDoNo2());
        stm.setString(6, leasingModel.getIdCopy());
        stm.setString(7, leasingModel.getGs());
        stm.setString(8, leasingModel.getGap());
        stm.setString(9, leasingModel.getGaranter());
        stm.setString(10, leasingModel.getLeasingName());
        stm.setString(11, leasingModel.getIdPhoto());
        stm.setString(12, leasingModel.getSnCharge());
        stm.setString(13, leasingModel.getLeasingId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateRmv(RmvModel rmvModel) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Rmv SET mta3 = ? , do = ? , idCopy = ? , idPhotos = ? WHERE rmvId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, rmvModel.getMta3());
        stm.setString(2, rmvModel.getDoNo());
        stm.setString(3, rmvModel.getIdCopy());
        stm.setString(4, rmvModel.getIdPhotos());
        stm.setString(5, rmvModel.getRmvId());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static void updateCRNPlate(CRNPlateInfo info) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE OrderTable SET isCrReceived = ? , isNPlateReceived = ? , "
                + "crReceivedDate = ? , nPlateReceivedDate = ? , "
                + "nPlateIssueDate = ? , cRIssueDate = ? WHERE orderId = ?  ";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setBoolean(1, info.isCr());
        stm.setBoolean(2, info.isnPlate());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String crR = null, crI = null;
        if (info.getCrR() != null) {
            crR = dateFormat.format(info.getCrR());
        }
        stm.setString(3, crR);

        String nPlateR = null, nPlateI = null;
        if (info.getnPlateR() != null) {
            nPlateR = dateFormat.format(info.getnPlateR());
        }
        stm.setString(4, nPlateR);
        if (info.getnPlateI() != null) {
            nPlateI = dateFormat.format(info.getnPlateI());
        }
        stm.setString(5, nPlateI);

        if (info.getCrI() != null) {
            crI = dateFormat.format(info.getCrI());
        }
        stm.setString(6, crI);

        stm.setString(7, info.getOrderId());
        int executeUpdate = stm.executeUpdate();
    }
}
