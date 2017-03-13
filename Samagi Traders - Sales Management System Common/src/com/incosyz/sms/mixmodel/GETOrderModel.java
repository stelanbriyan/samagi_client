/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

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
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Date : Nov 10, 2015 Time : 2:23:57 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class GETOrderModel implements Serializable {

    private OrderModel orderModel;
    private StockModel stockModel;
    private PaymentModel paymentModel;
    private UserModel userModel;
    private CustomerModel customerModel;
    private BikeModel bikeModel;
    private Model model;
    private ArrayList<CashModel> cashModels;
    private ArrayList<CheckModel> checkModels;
    private LeasingModel leasingModel;
    private ArrayList<MobileModel> mobileModels;
    private ArrayList<HomePhoneModel> homePhoneModels;
    private RmvModel rmvModel;

    /**
     * @return the orderModel
     */
    public OrderModel getOrderModel() {
        return orderModel;
    }

    /**
     * @param orderModel the orderModel to set
     */
    public GETOrderModel setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
        return this;
    }

    /**
     * @return the stockModel
     */
    public StockModel getStockModel() {
        return stockModel;
    }

    /**
     * @param stockModel the stockModel to set
     */
    public GETOrderModel setStockModel(StockModel stockModel) {
        this.stockModel = stockModel;
        return this;
    }

    /**
     * @return the userModel
     */
    public UserModel getUserModel() {
        return userModel;
    }

    /**
     * @param userModel the userModel to set
     */
    public GETOrderModel setUserModel(UserModel userModel) {
        this.userModel = userModel;
        return this;
    }

    /**
     * @return the customerModel
     */
    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    /**
     * @param customerModel the customerModel to set
     */
    public GETOrderModel setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
        return this;
    }

    /**
     * @return the bikeModel
     */
    public BikeModel getBikeModel() {
        return bikeModel;
    }

    /**
     * @param bikeModel the bikeModel to set
     */
    public GETOrderModel setBikeModel(BikeModel bikeModel) {
        this.bikeModel = bikeModel;
        return this;
    }

    /**
     * @return the paymentModel
     */
    public PaymentModel getPaymentModel() {
        return paymentModel;
    }

    /**
     * @param paymentModel the paymentModel to set
     */
    public GETOrderModel setPaymentModel(PaymentModel paymentModel) {
        this.paymentModel = paymentModel;
        return this;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public GETOrderModel setModel(Model model) {
        this.model = model;
        return this;
    }

    /**
     * @return the cashModels
     */
    public ArrayList<CashModel> getCashModels() {
        return cashModels;
    }

    /**
     * @param cashModels the cashModels to set
     */
    public GETOrderModel setCashModels(ArrayList<CashModel> cashModels) {
        this.cashModels = cashModels;
        return this;
    }

    /**
     * @return the checkModels
     */
    public ArrayList<CheckModel> getCheckModels() {
        return checkModels;
    }

    /**
     * @param checkModels the checkModels to set
     */
    public GETOrderModel setCheckModels(ArrayList<CheckModel> checkModels) {
        this.checkModels = checkModels;
        return this;
    }

    /**
     * @return the leasingModel
     */
    public LeasingModel getLeasingModel() {
        return leasingModel;
    }

    /**
     * @param leasingModel the leasingModel to set
     */
    public GETOrderModel setLeasingModel(LeasingModel leasingModel) {
        this.leasingModel = leasingModel;
        return this;
    }

    /**
     * @return the mobileModels
     */
    public ArrayList<MobileModel> getMobileModels() {
        return mobileModels;
    }

    /**
     * @param mobileModels the mobileModels to set
     */
    public GETOrderModel setMobileModels(ArrayList<MobileModel> mobileModels) {
        this.mobileModels = mobileModels;
        return this;
    }

    /**
     * @return the homePhoneModels
     */
    public ArrayList<HomePhoneModel> getHomePhoneModels() {
        return homePhoneModels;
    }

    /**
     * @param homePhoneModels the homePhoneModels to set
     */
    public GETOrderModel setHomePhoneModels(ArrayList<HomePhoneModel> homePhoneModels) {
        this.homePhoneModels = homePhoneModels;
        return this;
    }

    /**
     * @return the rmvModel
     */
    public RmvModel getRmvModel() {
        return rmvModel;
    }

    /**
     * @param rmvModel the rmvModel to set
     */
    public GETOrderModel setRmvModel(RmvModel rmvModel) {
        this.rmvModel = rmvModel;
        return this;
    }

}
