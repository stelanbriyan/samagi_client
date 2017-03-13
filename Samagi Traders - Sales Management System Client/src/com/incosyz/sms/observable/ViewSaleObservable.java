/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.observable;

import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.observer.ViewSaleObserver;
import com.incosyz.sms.view.Home;
import com.incosyz.sms.view.ViewSaleBigWindow;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Date : Nov 19, 2015 Time : 2:41:56 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ViewSaleObservable extends UnicastRemoteObject implements ViewSaleObserver {

    private ViewSaleBigWindow viewSaleBigWindow;

    public ViewSaleObservable(ViewSaleBigWindow viewSaleBigWindow) throws RemoteException {
        this.viewSaleBigWindow = viewSaleBigWindow;

    }

    @Override
    public void addNewOrder(GETOrderModel gETOrderModel) {
        viewSaleBigWindow.addNewOrder(gETOrderModel);
        Home.icon.displayMessage("New Sale Detail Done", "New Order Added. Round No : " + gETOrderModel.getOrderModel().getRoundNo() + "  Bike Model Name : " + gETOrderModel.getModel().getModelName() + " To Customer : " + gETOrderModel.getCustomerModel().getCustomerName(), TrayIcon.MessageType.NONE);
    }
}
