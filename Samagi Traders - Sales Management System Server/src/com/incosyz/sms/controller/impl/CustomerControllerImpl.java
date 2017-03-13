/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller.impl;

import com.incosyz.sms.controller.CustomerController;
import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.dbcontroller.CustomerDBController;
import com.incosyz.sms.dbcontroller.OrderDBController;
import com.incosyz.sms.mixmodel.CRNPlateInfo;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.LeasingModel;
import com.incosyz.sms.model.MobileModel;
import com.incosyz.sms.model.RmvModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 7, 2015 Time : 9:57:07 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController {

    public CustomerControllerImpl() throws RemoteException {

    }

    @Override
    public CustomerModel getCustomer(String nic) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.getCustomer(nic);
    }

    @Override
    public ArrayList<MobileModel> getMobile(String customerId) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.getMobile(customerId);
    }

    @Override
    public ArrayList<HomePhoneModel> getHomePhone(String customerId) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.getHomePhone(customerId);
    }

    @Override
    public boolean updateCustomer(CustomerModel customerModel) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.updateCustomerDetail(customerModel);
    }

    @Override
    public boolean updateHomePhone(ArrayList<HomePhoneModel> homePhoneModels) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.updateHomePhone(homePhoneModels);
    }

    @Override
    public boolean updateMobile(ArrayList<MobileModel> mobiles) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.updateMobile(mobiles);
    }

    @Override
    public boolean addCash(CashModel cashModel) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.addCash(cashModel);
    }

    @Override
    public boolean updateLeasing(LeasingModel leasingModel) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.updateLeasing(leasingModel);
    }

    @Override
    public boolean updateRmv(RmvModel rmvModel) throws ClassNotFoundException, SQLException, RemoteException {
        return CustomerDBController.updateRmv(rmvModel);
    }

    @Override
    public boolean addLeasing(LeasingModel leasingModel) throws ClassNotFoundException, SQLException, RemoteException {
        return OrderDBController.addLeasing(leasingModel, DBConnection.getDBConnection().getConnection());
    }

    @Override
    public void updateCRNPlate(CRNPlateInfo info) throws ClassNotFoundException, SQLException, RemoteException {
       CustomerDBController.updateCRNPlate(info);
    }

}
