/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observer;

import com.incosyz.sms.mixmodel.GETOrderModel;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date : Nov 19, 2015 Time : 2:40:03 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface ViewSaleObserver extends Remote {

    public void addNewOrder(GETOrderModel gETOrderModel) throws RemoteException;
}
