/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observable;

import com.incosyz.sms.observer.CreateNewSaleObserver;
import com.incosyz.sms.view.CreateNewSale;
import com.incosyz.sms.view.Home;
import java.awt.TrayIcon;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Date : Nov 22, 2015 Time : 7:42:25 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class CreateNewObserverble extends UnicastRemoteObject implements CreateNewSaleObserver {

    private CreateNewSale createNewSale;

    public CreateNewObserverble(CreateNewSale createNewSale) throws RemoteException {
        this.createNewSale = createNewSale;
    }

    @Override
    public void removeFromStock(String roundNo) throws RemoteException {
        createNewSale.removeStock(roundNo);
//        Home.icon.displayMessage("Stock Item removed from sale list", "Round No : " + roundNo + " removed from sale list", TrayIcon.MessageType.NONE);
    
    }
}
