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
import com.incosyz.sms.model.OrderModel;
import com.incosyz.sms.model.PaymentModel;
import com.incosyz.sms.model.RmvModel;
import com.incosyz.sms.model.UserModel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Date : Nov 6, 2015 Time : 5:53:45 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderSendModel implements Serializable {

    private CustomerModel customerModel;
    private ArrayList<HomePhoneModel> homePhoneModels;
    private ArrayList<MobileModel> mobileModels;
    private PaymentModel paymentModel;
    private CashModel cashModel;
    private ArrayList<CheckModel> checkModels;
    private LeasingModel leasingModel;
    private RmvModel rmvModel;
    private UserModel userModel;
    private OrderModel orderModel;
    private BikeModel bikeModel;
    

    /**
     * @return the customerModel
     */
    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    /**
     * @param customerModel the customerModel to set
     */
    public OrderSendModel setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
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
    public OrderSendModel setHomePhoneModels(ArrayList<HomePhoneModel> homePhoneModels) {
        this.homePhoneModels = homePhoneModels;
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
    public OrderSendModel setMobileModels(ArrayList<MobileModel> mobileModels) {
        this.mobileModels = mobileModels;
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
    public OrderSendModel setPaymentModel(PaymentModel paymentModel) {
        this.paymentModel = paymentModel;
        return this;
    }

    /**
     * @return the cashModel
     */
    public CashModel getCashModel() {
        return cashModel;
    }

    /**
     * @param cashModel the cashModel to set
     */
    public OrderSendModel setCashModel(CashModel cashModel) {
        this.cashModel = cashModel;
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
    public OrderSendModel setCheckModels(ArrayList<CheckModel> checkModels) {
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
    public OrderSendModel setLeasingModel(LeasingModel leasingModel) {
        this.leasingModel = leasingModel;
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
    public OrderSendModel setRmvModel(RmvModel rmvModel) {
        this.rmvModel = rmvModel;
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
    public OrderSendModel setUserModel(UserModel userModel) {
        this.userModel = userModel;
        return this;
    }

    /**
     * @return the orderModel
     */
    public OrderModel getOrderModel() {
        return orderModel;
    }

    /**
     * @param orderModel the orderModel to set
     */
    public OrderSendModel setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
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
    public OrderSendModel setBikeModel(BikeModel bikeModel) {
        this.bikeModel = bikeModel;
        return this;
    }

}
