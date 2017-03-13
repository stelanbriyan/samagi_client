/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.server;

import com.incosyz.sms.controller.impl.FactoryControllerImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stelan
 */
public class ServerStart {

    public static void startServer() throws RemoteException {

        Registry registry = LocateRegistry.createRegistry(5050);
        registry.rebind("sms", new FactoryControllerImpl());

    }
}
