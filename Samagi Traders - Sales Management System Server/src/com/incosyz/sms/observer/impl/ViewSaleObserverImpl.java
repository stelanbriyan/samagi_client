/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observer.impl;

import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.observer.ViewSaleObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Date : Nov 19, 2015 Time : 2:46:00 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ViewSaleObserverImpl {

    private ArrayList<ViewSaleObserver> viewSaleObservers = new ArrayList<ViewSaleObserver>();

    public void addObserver(ViewSaleObserver viewSaleObserver) {
        viewSaleObservers.add(viewSaleObserver);
    }

    public void removeObserver(ViewSaleObserver viewSaleObserver) {
        viewSaleObservers.remove(viewSaleObserver);
    }

    public void addNewOrder(GETOrderModel gETOrderModel) throws RemoteException {
        for (ViewSaleObserver viewSaleObserver : viewSaleObservers) {
            viewSaleObserver.addNewOrder(gETOrderModel);
        }
    }
}
