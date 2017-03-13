/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date : Nov 22, 2015 Time : 7:42:55 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public interface CreateNewSaleObserver extends Remote {

    public void removeFromStock(String roundNo) throws RemoteException;
}
