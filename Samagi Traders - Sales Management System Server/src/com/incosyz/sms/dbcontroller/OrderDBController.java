/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.controller.OrderController;
import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.mixmodel.LeasingOrderModel;
import com.incosyz.sms.mixmodel.OrderSendModel;
import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.AcountModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.LeasingModel;
import com.incosyz.sms.model.MobileModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PaymentModel;
import com.incosyz.sms.model.RmvModel;
import com.incosyz.sms.model.UserModel;
import com.incosyz.sms.other.IDGenerator;
import com.incosyz.sms.server.ServerForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 6, 2015 Time : 6:08:10 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderDBController {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static boolean addOrder(OrderSendModel orderSendModel) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getDBConnection().getConnection();
        con.setAutoCommit(false);

        CustomerModel customerModel = orderSendModel.getCustomerModel();
        ArrayList<MobileModel> mobileModels = orderSendModel.getMobileModels();
        ArrayList<HomePhoneModel> homePhoneModels = orderSendModel.getHomePhoneModels();
        PaymentModel paymentModel = orderSendModel.getPaymentModel();
        CashModel cashModel = orderSendModel.getCashModel();
        ArrayList<CheckModel> checkModels = orderSendModel.getCheckModels();
        LeasingModel leasingModel = orderSendModel.getLeasingModel();
        RmvModel rmvModel = orderSendModel.getRmvModel();
        OrderModel orderModel = orderSendModel.getOrderModel();

        try {
            boolean addCustomer = CustomerDBController.addCustomer(customerModel, con);
            if (addCustomer) {
                boolean addMobile = CustomerDBController.addMobile(mobileModels, con);
                if (!addMobile) {
                    con.rollback();
                    return false;
                }

                boolean addHomePhone = CustomerDBController.addHomePhone(homePhoneModels, con);
                if (!addHomePhone) {
                    con.rollback();
                    return false;
                }

                boolean addPayment = addPayment(paymentModel, con);
                if (addPayment) {

                    if (cashModel != null) {
                        boolean addCash = addCash(cashModel, con);
                        if (!addCash) {
                            con.rollback();
                            return false;
                        }
                    }

                    boolean addCheque = addCheque(checkModels, customerModel.getCustomerName(), con);
                    if (!addCheque) {
                        con.rollback();
                        return false;
                    }

                    boolean addLeasing = addLeasing(leasingModel, con);
                    if (!addLeasing) {
                        con.rollback();
                        return false;

                    }
                } else {
                    con.rollback();
                    return false;
                }

                boolean addRmv = addRmv(rmvModel, con);
                if (!addRmv) {
                    con.rollback();
                    return false;
                }

                boolean addOrder = addOrder(orderModel, con);
                if (!addOrder) {
                    con.rollback();
                    return false;
                }
            } else {
                return false;
            }
        } finally {
            con.setAutoCommit(true);
        }
        return true;
//        try {
//            CustomerModel customerModel = orderSendModel.getCustomerModel();
//            boolean isCustomerAdded;
////            if (CustomerDBController.isExistCustomer(customerModel.getNicNo())) {
////                isCustomerAdded = CustomerDBController.updateCustomer(customerModel);
////            } else {
//            isCustomerAdded = CustomerDBController.addCustomer(customerModel, con);  // Customer Addings
////            }
//
//            if (isCustomerAdded) {
//                ArrayList<MobileModel> mobileModels = orderSendModel.getMobileModels();
//                boolean isMobileAdded = CustomerDBController.addMobile(mobileModels, con);   // Mobile adding
//
//                ArrayList<HomePhoneModel> homePhoneModels = orderSendModel.getHomePhoneModels();
//                boolean isHomePhoneAdded = CustomerDBController.addHomePhone(homePhoneModels, con);   // Home phone adding
//
//                PaymentModel paymentModel = orderSendModel.getPaymentModel();   // Payment adding
//                boolean isPayment = addPayment(paymentModel, con);
//
//                if (isPayment) {
//                    CashModel cashModel = orderSendModel.getCashModel(); // Cash adding
//                    if (cashModel != null) {
//                        boolean isCash = addCash(cashModel, con);
//                    }
//
//                    ArrayList<CheckModel> checkModels = orderSendModel.getCheckModels(); // Cheque Adding
//                    if (checkModels != null) {
//                        boolean isCheques = addCheque(checkModels, customerModel.getCustomerName(), con);
//                    }
//
//                    LeasingModel leasingModel = orderSendModel.getLeasingModel(); // Leasing Adding
//                    if (leasingModel != null) {
//                        boolean isLeasing = addLeasing(leasingModel, con);
//                    }
//
//                    RmvModel rmvModel = orderSendModel.getRmvModel(); // RMV Adding
//                    if (rmvModel != null) {
//                        boolean isRmv = addRmv(rmvModel, con);
//                    }
//
//                    OrderModel orderModel = orderSendModel.getOrderModel(); // Order Adding                    
//
//                    boolean isOrder = addOrder(orderModel, con);
//
//                    if (isOrder) {
//                        con.setAutoCommit(true);
//                    } else {
//                        con.rollback();
//                    }
//
//                } else {
//                    con.rollback();
//                }
//
//            } else {
//                con.rollback();
//            }
//        } finally {
//            con.setAutoCommit(true);
//        }
    }

    public static boolean addOrder(OrderModel orderModel, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            String sql = "INSERT INTO OrderTable VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, orderModel.getOrderId());
            stm.setString(2, orderModel.getRoundNo());
            stm.setString(3, orderModel.getBikeModelId());
            stm.setString(4, orderModel.getCustomerId());
            stm.setString(5, orderModel.getRmvId());
            stm.setString(6, orderModel.getUserId());
            stm.setString(7, orderModel.getPaymentId());
            stm.setString(8, orderModel.getOrderTime());
            stm.setString(9, orderModel.getOrderDate());
            stm.setString(10, orderModel.getNote());
            stm.setString(11, orderModel.getOrderAmount());
            stm.setString(12, orderModel.getRmv());
            stm.setString(13, orderModel.getInsurance());
            int execute = stm.executeUpdate();
            if (execute > 0) {
                ServerForm.getServerForm().setDesc("data recode write for new sale detail");
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static boolean addPayment(PaymentModel paymentModel, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            String sql = "INSERT INTO Payment VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, paymentModel.getPaymentId());
            stm.setString(2, paymentModel.getCommision());
            stm.setString(3, paymentModel.getBikeAmount());
            stm.setString(4, paymentModel.getRmvAmount());
            stm.setString(5, paymentModel.getInsuranceAmount());
            stm.setString(6, paymentModel.getOrderAmount());
            stm.setString(7, paymentModel.getOtherPaymentAmount());
            stm.setString(8, paymentModel.getNote());
            int execute = stm.executeUpdate();
            if (execute > 0) {
                ServerForm.getServerForm().setDesc("payment completed");
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static boolean addCash(CashModel cashModel, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            String sql = "INSERT INTO Cash VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cashModel.getCashId());
            stm.setString(2, cashModel.getPaymentId());
            stm.setString(3, cashModel.getCashAmount());
            stm.setString(4, cashModel.getCashDate());
            int execute = stm.executeUpdate();
            if (execute > 0) {
                ServerForm.getServerForm().setDesc("cash detail recode");
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static boolean addCheque(ArrayList<CheckModel> checkModels, String customerName, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            if (checkModels == null) {
                checkModels = new ArrayList<>();
            }
            String sql = "INSERT INTO Cheque VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            int execute = 0;
            String chequeId = IDGenerator.getNewId("Cheque", "chequeId", "C", 3);
            for (CheckModel checkModel : checkModels) {
                PreparedStatement stm = con.prepareStatement(sql);
                if (execute >= 1) {
                    chequeId = IDGenerator.getNewId("Cheque", "chequeId", "C", 3, chequeId);
                }
                stm.setString(1, chequeId);
                stm.setString(2, checkModel.getPaymentId());
                stm.setString(3, checkModel.getCheckNo());
                stm.setString(4, checkModel.getBankName());
                stm.setString(5, checkModel.getChequeDate());
                stm.setString(6, checkModel.getAmount());
                stm.setString(7, checkModel.getStateName());
                stm.setString(8, customerName);
                stm.setString(9, checkModel.getType());
                stm.setString(10, checkModel.getAccountNo());
                stm.setString(11, checkModel.getNote());
                stm.setString(12, "0");
                execute += stm.executeUpdate();
            }
            if (checkModels.size() == execute) {
                ServerForm.getServerForm().setDesc("cheque detail recode " + execute + " done");
                return true;
            }

            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static boolean addLeasing(LeasingModel leasingModel, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            if (leasingModel == null) {
                return true;
            }
            String sql = "INSERT INTO Leasing VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            System.out.println(leasingModel.getLeasingId());
            stm.setString(1, leasingModel.getLeasingId());
            stm.setString(2, leasingModel.getPaymentId());
            stm.setString(3, leasingModel.getLeasingAmount());
            stm.setString(4, leasingModel.getMta());
            stm.setString(5, leasingModel.getMta2());
            stm.setString(6, leasingModel.getMta3());
            stm.setString(7, leasingModel.getDoNo());
            stm.setString(8, leasingModel.getDoNo2());
            stm.setString(9, leasingModel.getIdCopy());
            stm.setString(10, leasingModel.getGs());
            stm.setString(11, leasingModel.getGap());
            stm.setString(12, leasingModel.getGaranter());
            stm.setString(13, leasingModel.getLeasingName());
            stm.setString(14, leasingModel.getIdPhoto());
            stm.setString(15, leasingModel.getSnCharge());
            int execute = stm.executeUpdate();
            if (execute > 0) {
                ServerForm.getServerForm().setDesc("leasing detail recode");
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static boolean addRmv(RmvModel rmvModel, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            if (rmvModel == null) {
                return true;
            }
            String sql = "INSERT INTO Rmv VALUES(?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, rmvModel.getRmvId());
            stm.setString(2, rmvModel.getMta3());
            stm.setString(3, rmvModel.getDoNo());
            stm.setString(4, rmvModel.getIdCopy());
            stm.setString(5, rmvModel.getIdPhotos());
            stm.setString(6, rmvModel.getIsLeasing());
            int execute = stm.executeUpdate();
            if (execute > 0) {
                ServerForm.getServerForm().setDesc("rmv detail recode");
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static ArrayList<GETOrderModel> getOrders() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM OrderTable ORDER BY 1 DESC";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
//        stm.setString(1, String.valueOf(showCount));
            ResultSet executeQuery = stm.executeQuery();

            ArrayList<GETOrderModel> gETOrderModels = new ArrayList<>();

            while (executeQuery.next()) {
                String orderId = executeQuery.getString(1);
                String roundNo = executeQuery.getString(2);
                String bikeModelId = executeQuery.getString(3);
                String customerId = executeQuery.getString(4);
                String rmvId = executeQuery.getString(5);
                String userId = executeQuery.getString(6);
                String paymentId = executeQuery.getString(7);
                String orderTime = executeQuery.getString(8);
                String orderDate = executeQuery.getString(9);
                String note = executeQuery.getString(10);
                String orderAmount = executeQuery.getString(11);
                String rmv = executeQuery.getString(12);
                String insurance = executeQuery.getString(13);

                OrderModel orderModel = new OrderModel()
                        .setOrderId(orderId)
                        .setRoundNo(roundNo)
                        .setBikeModelId(bikeModelId)
                        .setCustomerId(customerId)
                        .setRmv(rmvId)
                        .setUserId(userId)
                        .setPaymentId(paymentId)
                        .setOrderTime(orderTime)
                        .setOrderDate(orderDate)
                        .setNote(note)
                        .setOrderAmount(orderAmount)
                        .setRmv(rmv)
                        .setInsurance(insurance);
                orderModel.setCr(executeQuery.getBoolean(14));
                orderModel.setnPlate(executeQuery.getBoolean(15));

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String crRD = executeQuery.getString(16);
                try {
                    if (crRD != null) {
                        orderModel.setCrR(dateFormat.parse(crRD));
                    }

                    String nPlateRD = executeQuery.getString(17);
                    if (nPlateRD != null) {
                        orderModel.setnPlateR(dateFormat.parse(nPlateRD));
                    }

                    String nPlateID = executeQuery.getString(18);
                    if (nPlateID != null) {
                        orderModel.setnPlateI(dateFormat.parse(nPlateID));
                    }

                    String crID = executeQuery.getString(19);
                    if (crID != null) {
                        orderModel.setCrI(dateFormat.parse(crID));
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(OrderDBController.class.getName()).log(Level.SEVERE, null, ex);
                }
                StockModel stockModel = getStockModel(roundNo, con);
                PaymentModel paymentModel = getPaymentModel(paymentId, con);
                CustomerModel customerModel = getCustomer(customerId, con);
                UserModel userModel = getUser(userId, con);
                Model model = getModel(stockModel.getModelId(), con);
                ArrayList<CashModel> cash = getCash(paymentId, con);
                ArrayList<CheckModel> cheque = getCheque(paymentId, con);
                LeasingModel leasing = getLeasing(paymentId, con);
                ArrayList<MobileModel> mobile = getMobile(customerId, con);
                ArrayList<HomePhoneModel> homePhone = getHomePhone(customerId, con);
                RmvModel rmvModel = getRMV(rmvId);
                BikeModel bikeModel = getBikeModel(bikeModelId, con);

                GETOrderModel gETOrderModel = new GETOrderModel()
                        .setOrderModel(orderModel)
                        .setStockModel(stockModel)
                        .setPaymentModel(paymentModel)
                        .setCustomerModel(customerModel)
                        .setUserModel(userModel)
                        .setModel(model)
                        .setCashModels(cash)
                        .setCheckModels(cheque)
                        .setLeasingModel(leasing)
                        .setMobileModels(mobile)
                        .setHomePhoneModels(homePhone)
                        .setRmvModel(rmvModel)
                        .setBikeModel(bikeModel);

                gETOrderModels.add(gETOrderModel);
            }
            ServerForm.getServerForm().setDesc("read all sale details");
            return gETOrderModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static BikeModel getBikeModel(String bikeModelId, Connection con) throws SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM BikeModel WHERE bikeModelId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, bikeModelId);
            ResultSet executeQuery = stm.executeQuery();
            if (executeQuery.next()) {
                BikeModel bikeModel = new BikeModel()
                        .setBikeModelId(bikeModelId)
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
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static StockModel getStockModel(String roundNo, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Stock WHERE roundNo = ?";
//        Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, roundNo);
            ResultSet executeQuery = stm.executeQuery();

            StockModel stockModel = null;
            if (executeQuery.next()) {
                stockModel = new StockModel()
                        .setBatchId(executeQuery.getString(1))
                        .setModelId(executeQuery.getString(2))
                        .setRoundNo(executeQuery.getString(3))
                        .setEngineNo(executeQuery.getString(4))
                        .setStateName(executeQuery.getString(5))
                        .setIsSold(executeQuery.getString(6))
                        .setRemark(executeQuery.getString(7))
                        .setChassisNo(executeQuery.getString(8))
                        .setColour(executeQuery.getString(10));
                return stockModel;
            }
            return stockModel;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static PaymentModel getPaymentModel(String paymentId, Connection con) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Payment WHERE paymentId = ?";
//        Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, paymentId);
            ResultSet executeQuery = stm.executeQuery();

            PaymentModel paymentModel = null;
            if (executeQuery.next()) {
                paymentModel = new PaymentModel()
                        .setPaymentId(executeQuery.getString(1))
                        .setCommision(executeQuery.getString(2))
                        .setBikeAmount(executeQuery.getString(3))
                        .setRmvAmount(executeQuery.getString(4))
                        .setInsuranceAmount(executeQuery.getString(5))
                        .setOrderAmount(executeQuery.getString(6))
                        .setOtherPaymentAmount(executeQuery.getString(7))
                        .setNote(executeQuery.getString(8));
                return paymentModel;
            }
            return paymentModel;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static CustomerModel getCustomer(String customerId, Connection con) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Customer WHERE customerId = ?";
//        Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, customerId);
            ResultSet executeQuery = stm.executeQuery();

            CustomerModel customerModel = null;
            if (executeQuery.next()) {
                customerModel = new CustomerModel()
                        .setCustomerId(executeQuery.getString(1))
                        .setCustomerName(executeQuery.getString(2))
                        .setNicNo(executeQuery.getString(3))
                        .setAddressLineOne(executeQuery.getString(4))
                        .setAddressLineTwo(executeQuery.getString(5))
                        .setAddressLineThree(executeQuery.getString(6));

                return customerModel;
            }
            return customerModel;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static UserModel getUser(String userId, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Users WHERE userId = ?";
//        Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, userId);
            ResultSet executeQuery = stm.executeQuery();
            UserModel userModel = null;
            if (executeQuery.next()) {
                userModel = new UserModel()
                        .setUserId(executeQuery.getString(1))
                        .setUserName(executeQuery.getString(2))
                        .setPassword(executeQuery.getString(3))
                        .setUserType(executeQuery.getString(4));
                return userModel;
            }
            return userModel;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static Model getModel(String modelId, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Model WHERE modelId = ?";
//        Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, modelId);
            ResultSet executeQuery = stm.executeQuery();
            if (executeQuery.next()) {
                Model model = new Model()
                        .setModelId(executeQuery.getString(1))
                        .setModelName(executeQuery.getString(2));
                return model;
            }
            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<CashModel> getCash(String paymentId, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Cash WHERE paymentId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, paymentId);
            ResultSet executeQuery = stm.executeQuery();
            ArrayList<CashModel> cashModels = new ArrayList<>();
            while (executeQuery.next()) {
                CashModel cashModel = new CashModel()
                        .setCashId(executeQuery.getString(1))
                        .setPaymentId(executeQuery.getString(2))
                        .setCashAmount(executeQuery.getString(3))
                        .setCashDate(executeQuery.getString(4));
                cashModels.add(cashModel);
            }
            return cashModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<CheckModel> getCheque(String paymentId, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Cheque WHERE paymentId = ? AND stateName != 'Returned'";
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
                        .setStateName(executeQuery.getString(7));
                checkModels.add(checkModel);
            }
            return checkModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static LeasingModel getLeasing(String paymentId, Connection con) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Leasing WHERE paymentId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, paymentId);
            ResultSet executeQuery = stm.executeQuery();
            if (executeQuery.next()) {
                LeasingModel leasingModel = new LeasingModel()
                        .setLeasingId(executeQuery.getString(1))
                        .setPaymentId(executeQuery.getString(2))
                        .setLeasingAmount(executeQuery.getString(3))
                        .setMta(executeQuery.getString(4))
                        .setMta2(executeQuery.getString(5))
                        .setMta3(executeQuery.getString(6))
                        .setDoNo(executeQuery.getString(7))
                        .setDoNo2(executeQuery.getString(8))
                        .setIdCopy(executeQuery.getString(9))
                        .setGs(executeQuery.getString(10))
                        .setGap(executeQuery.getString(11))
                        .setGaranter(executeQuery.getString(12))
                        .setLeasingName(executeQuery.getString(13))
                        .setIdPhoto(executeQuery.getString(14))
                        .setSnCharge(executeQuery.getString(15));

                return leasingModel;
            }
            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public static ArrayList<MobileModel> getMobile(String customerId, Connection con) throws SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Mobile WHERE customerId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, customerId);
            ResultSet executeQuery = stm.executeQuery();

            ArrayList<MobileModel> mobileModels = new ArrayList<>();
            while (executeQuery.next()) {
                MobileModel mobileModel = new MobileModel()
                        .setCustomerId(customerId)
                        .setMobileId(executeQuery.getString(1))
                        .setMobileNo(executeQuery.getString(3));
                mobileModels.add(mobileModel);
            }
            return mobileModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<HomePhoneModel> getHomePhone(String customerId, Connection con) throws SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM HomePhone WHERE customerId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, customerId);
            ResultSet executeQuery = stm.executeQuery();
            ArrayList<HomePhoneModel> homePhoneModels = new ArrayList<>();
            while (executeQuery.next()) {
                HomePhoneModel homePhoneModel = new HomePhoneModel()
                        .setCustomerId(customerId)
                        .setHomePhoneId(executeQuery.getString(1))
                        .setHomePhoneNo(executeQuery.getString(3));
                homePhoneModels.add(homePhoneModel);
            }
            return homePhoneModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private static RmvModel getRMV(String rmvId) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Rmv WHERE rmvId = '" + rmvId + "'";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet executeQuery = stm.executeQuery();
            if (executeQuery.next()) {
                RmvModel model = new RmvModel()
                        .setRmvId(rmvId)
                        .setMta3(executeQuery.getString(2))
                        .setDoNo(executeQuery.getString(3))
                        .setIdCopy(executeQuery.getString(4))
                        .setIdPhotos(executeQuery.getString(5))
                        .setIsLeasing(executeQuery.getString(6));

                return model;
            }
            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<GETOrderModel> getOrders(String fromDate, String toDate) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM OrderTable WHERE orderDate BETWEEN ? AND ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, fromDate);
            stm.setString(2, toDate);
            ResultSet executeQuery = stm.executeQuery();

            ArrayList<GETOrderModel> gETOrderModels = new ArrayList<>();

            while (executeQuery.next()) {
                String orderId = executeQuery.getString(1);
                String roundNo = executeQuery.getString(2);
                String bikeModelId = executeQuery.getString(3);
                String customerId = executeQuery.getString(4);
                String rmvId = executeQuery.getString(5);
                String userId = executeQuery.getString(6);
                String paymentId = executeQuery.getString(7);
                String orderTime = executeQuery.getString(8);
                String orderDate = executeQuery.getString(9);
                String note = executeQuery.getString(10);
                String orderAmount = executeQuery.getString(11);
                String rmv = executeQuery.getString(12);
                String insurance = executeQuery.getString(13);

                OrderModel orderModel = new OrderModel()
                        .setOrderId(orderId)
                        .setRoundNo(roundNo)
                        .setBikeModelId(bikeModelId)
                        .setCustomerId(customerId)
                        .setRmv(rmvId)
                        .setUserId(userId)
                        .setPaymentId(paymentId)
                        .setOrderTime(orderTime)
                        .setOrderDate(orderDate)
                        .setNote(note)
                        .setOrderAmount(orderAmount)
                        .setRmv(rmv)
                        .setInsurance(insurance);

                StockModel stockModel = getStockModel(roundNo, con);
                PaymentModel paymentModel = getPaymentModel(paymentId, con);
                CustomerModel customerModel = getCustomer(customerId, con);
                UserModel userModel = getUser(userId, con);
                Model model = getModel(stockModel.getModelId(), con);
                ArrayList<CashModel> cash = getCash(paymentId, con);
                ArrayList<CheckModel> cheque = getCheque(paymentId, con);
                LeasingModel leasing = getLeasing(paymentId, con);
                ArrayList<MobileModel> mobile = getMobile(customerId, con);
                ArrayList<HomePhoneModel> homePhone = getHomePhone(customerId, con);
                RmvModel rmvModel = getRMV(rmvId);
                BikeModel bikeModel = getBikeModel(bikeModelId, con);

                GETOrderModel gETOrderModel = new GETOrderModel()
                        .setOrderModel(orderModel)
                        .setStockModel(stockModel)
                        .setPaymentModel(paymentModel)
                        .setCustomerModel(customerModel)
                        .setUserModel(userModel)
                        .setModel(model)
                        .setCashModels(cash)
                        .setCheckModels(cheque)
                        .setLeasingModel(leasing)
                        .setMobileModels(mobile)
                        .setHomePhoneModels(homePhone)
                        .setRmvModel(rmvModel)
                        .setBikeModel(bikeModel);

                gETOrderModels.add(gETOrderModel);
            }
            ServerForm.getServerForm().setDesc("sales recode reading........");
            return gETOrderModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static boolean addAccount(AcountModel acountModel) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "INSERT INTO Account(accountDate , description, income, expenditure) VALUES(?,?,?,?)";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, acountModel.getDate());
            stm.setString(2, acountModel.getDescription());
            stm.setString(3, acountModel.getIncome());
            stm.setString(4, acountModel.getExpenditure());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
            return false;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<AcountModel> getAccount(String dateFrom, String dateTo) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Account WHERE accountDate BETWEEN ? AND ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, dateFrom);
            stm.setString(2, dateTo);
            ResultSet executeQuery = stm.executeQuery();
            ArrayList<AcountModel> acountModels = new ArrayList<>();
            while (executeQuery.next()) {
                AcountModel acountModel = new AcountModel()
                        .setAcountId(executeQuery.getString(1))
                        .setDate(executeQuery.getString(2))
                        .setDescription(executeQuery.getString(3))
                        .setIncome(executeQuery.getString(4))
                        .setExpenditure(executeQuery.getString(5));
                acountModels.add(acountModel);
            }
            return acountModels;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static ArrayList<CheckModel> getCheque(String dateFrom, String dateTo) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            String sql = "SELECT * FROM Cheque WHERE chequeDate BETWEEN ? AND ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, dateFrom);
            stm.setString(2, dateTo);
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
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static boolean deleteAcount(AcountModel acountModel) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().unlock();
            String sql = "DELETE FROM Account WHERE accountId = ?";
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, acountModel.getAcountId());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static OrderModel getOrder(String roundNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT roundNo , customerName , orderDate , orderAmount FROM OrderTable , Customer  WHERE OrderTable.customerId = Customer.customerId AND roundNo = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, roundNo);
        ResultSet executeQuery = prepareStatement.executeQuery();
        if (executeQuery.next()) {
            OrderModel orderModel = new OrderModel();
            orderModel.setRoundNo(executeQuery.getString(1));
            orderModel.setCustomerId(executeQuery.getString(2));
            orderModel.setOrderDate(executeQuery.getString(3));
            orderModel.setOrderAmount(executeQuery.getString(4));
            return orderModel;
        }
        return null;
    }

    public static boolean leasingExists(String paymentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Leasing WHERE PaymentId = ?";
        Connection con = (Connection) DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, paymentId);
        ResultSet executeQuery = prepareStatement.executeQuery();
        if (executeQuery.next()) {
            return true;
        }
        return false;
    }

    public static ArrayList<LeasingOrderModel> getLeasingDetail(String from, String to) throws ClassNotFoundException, SQLException {
        String sql = "select roundNo , leasingName , leasingAmount , mta , mta2 , mta3 , do , do2 , idCopy , gs, gap , garanter , idPhoto , snCharge from leasing , ordertable where leasing.paymentId = ordertable.paymentId AND orderDate between ? and ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, from);
        stm.setString(2, to);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<LeasingOrderModel> leasingOrderModels = new ArrayList<>();
        while (executeQuery.next()) {
            LeasingOrderModel leasingOrderModel = new LeasingOrderModel();
            leasingOrderModel.setRoundNo(executeQuery.getString(1));
            leasingOrderModel.setLeasingName(executeQuery.getString(2));
            leasingOrderModel.setLeasingAmount(executeQuery.getString(3));
            leasingOrderModel.setMta(executeQuery.getString(4));
            leasingOrderModel.setMta2(executeQuery.getString(5));
            leasingOrderModel.setMta3(executeQuery.getString(6));
            leasingOrderModel.setDo1(executeQuery.getString(7));
            leasingOrderModel.setDo2(executeQuery.getString(8));
            leasingOrderModel.setIdCopy(executeQuery.getString(9));
            leasingOrderModel.setGs(executeQuery.getString(10));
            leasingOrderModel.setGap(executeQuery.getString(11));
            leasingOrderModel.setGaranter(executeQuery.getString(12));
            leasingOrderModel.setIdPhoto(executeQuery.getString(13));
            leasingOrderModel.setSnCharge(executeQuery.getString(14));
            leasingOrderModels.add(leasingOrderModel);
        }
        return leasingOrderModels;
    }
}
