/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observer.impl;

import com.incosyz.sms.observer.CreateNewSaleObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Date : Nov 22, 2015 Time : 7:49:38 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CreateNewSaleObserverImpl {

    private ArrayList<CreateNewSaleObserver> createNewSaleObservers = new ArrayList<CreateNewSaleObserver>();

    public boolean addObserver(CreateNewSaleObserver createNewSaleObserver) {
        return createNewSaleObservers.add(createNewSaleObserver);
    }

    public boolean removeObserver(CreateNewSaleObserver createNewSaleObserver) {
        return createNewSaleObservers.remove(createNewSaleObserver);
    }

    public void removeStockItem(String roundNo) throws RemoteException {
        for (CreateNewSaleObserver createNewSaleObserver : createNewSaleObservers) {
            createNewSaleObserver.removeFromStock(roundNo);
        }
    }
}
