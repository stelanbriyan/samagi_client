/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.clientcontroller;

import com.incosyz.sms.controller.CustomerController;
import com.incosyz.sms.mixmodel.CRNPlateInfo;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.LeasingModel;
import com.incosyz.sms.model.MobileModel;
import com.incosyz.sms.model.RmvModel;
import com.incosyz.sms.server.ServerConnector;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 7, 2015 Time : 10:10:25 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CustomerControllerImplClient {

    public static CustomerModel getCustomer(String nic) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().getCustomer(nic);
    }

    public static ArrayList<MobileModel> getMobile(String customerId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().getMobile(customerId);
    }

    public static ArrayList<HomePhoneModel> getHomePhone(String customerId) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().getHomePhone(customerId);
    }

    public static boolean updateCustomer(CustomerModel customerModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().updateCustomer(customerModel);
    }

    public static boolean updateMobile(ArrayList<MobileModel> mobiles) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().updateMobile(mobiles);
    }

    public static boolean updateHome(ArrayList<HomePhoneModel> homePhoneModels) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().updateHomePhone(homePhoneModels);
    }

    public static boolean addCash(CashModel cashModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().addCash(cashModel);
    }

    public static boolean updateLeasing(LeasingModel leasingModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().updateLeasing(leasingModel);
    }

    public static boolean updateRmv(RmvModel rmvModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().updateRmv(rmvModel);
    }

    public static boolean addLeasing(LeasingModel leasingModel) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        return ServerConnector.getServerConnector().getCustomerController().addLeasing(leasingModel);
    }

    public static void updateCRNPlate(CRNPlateInfo info) throws NotBoundException, MalformedURLException, ClassNotFoundException, SQLException, RemoteException {
        ServerConnector.getServerConnector().getCustomerController().updateCRNPlate(info);
    }
}
