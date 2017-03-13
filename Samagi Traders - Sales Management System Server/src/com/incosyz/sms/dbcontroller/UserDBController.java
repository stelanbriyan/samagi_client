/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.mixmodel.UserOrderModel;
import com.incosyz.sms.model.UserModel;
import com.incosyz.sms.server.ServerForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Date : Nov 18, 2015 Time : 5:50:03 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UserDBController {

    public static boolean addUser(UserModel model) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Users VALUES(?,?,?,?)";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, model.getUserId());
        stm.setString(2, model.getUserName());
        stm.setString(3, model.getPassword());
        stm.setString(4, model.getUserType());
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        ServerForm.getServerForm().setDesc("write new user");
        return false;
    }

    public static ArrayList<UserModel> getUsers() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Users";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<UserModel> userModels = new ArrayList<>();
        while (executeQuery.next()) {
            UserModel userModel = new UserModel();
            userModel.setUserId(executeQuery.getString(1));
            userModel.setUserName(executeQuery.getString(2));
            userModel.setPassword(executeQuery.getString(3));
            userModel.setUserType(executeQuery.getString(4));
            userModels.add(userModel);
        }
        ServerForm.getServerForm().setDesc("read all users details. new user login");
        return userModels;
    }

    public static boolean deleteUser(String userId) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Users WHERE userId = ?";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userId);
        int executeUpdate = stm.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<UserOrderModel> getUserLogger() throws ClassNotFoundException, SQLException {
        String sql = "SELECT users.userId, userName , userType , count(orderId) , orderDate , sum(orderAmount) FROM orderTable , users WHERE Users.userId = OrderTable.userId GROUP BY orderDate";
        Connection con = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery();
        ArrayList<UserOrderModel> userOrderModels = new ArrayList<>();
        while (executeQuery.next()) {
            UserOrderModel model = new UserOrderModel()
                    .setUserId(executeQuery.getString(1))
                    .setUserName(executeQuery.getString(2))
                    .setUserType(executeQuery.getString(3))
                    .setOrderCount(executeQuery.getString(4))
                    .setOrderDate(executeQuery.getString(5))
                    .setSaleAmount(executeQuery.getString(6));
            userOrderModels.add(model);
        }
        return userOrderModels;
    }

    public static int getUserCount() throws ClassNotFoundException, SQLException {
        String sql = "SELECT count(userId) FROM Users";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.prepareStatement(sql);
        ResultSet executeQuery = stm.executeQuery(sql);
        if (executeQuery.next()) {
            String string = executeQuery.getString(1);
            if (!string.equals("") || string != null) {
                return Integer.parseInt(string);
            }
        }
        return 0;
    }

}
