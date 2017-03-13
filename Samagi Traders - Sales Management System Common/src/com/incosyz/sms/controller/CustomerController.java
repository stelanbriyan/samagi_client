/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.controller;

import com.incosyz.sms.mixmodel.CRNPlateInfo;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CustomerModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.LeasingModel;
import com.incosyz.sms.model.MobileModel;
import com.incosyz.sms.model.RmvModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Date : Nov 7, 2015 Time : 9:55:48 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface CustomerController extends Remote {

    public CustomerModel getCustomer(String nic) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<MobileModel> getMobile(String customerId) throws ClassNotFoundException, SQLException, RemoteException;

    public ArrayList<HomePhoneModel> getHomePhone(String customerId) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateCustomer(CustomerModel customerModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateHomePhone(ArrayList<HomePhoneModel> homePhoneModels) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateMobile(ArrayList<MobileModel> mobiles) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addCash(CashModel cashModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateLeasing(LeasingModel leasingModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean updateRmv(RmvModel rmvModel) throws ClassNotFoundException, SQLException, RemoteException;

    public boolean addLeasing(LeasingModel leasingModel) throws ClassNotFoundException, SQLException, RemoteException;

    public void updateCRNPlate(CRNPlateInfo info) throws ClassNotFoundException, SQLException, RemoteException;

}
