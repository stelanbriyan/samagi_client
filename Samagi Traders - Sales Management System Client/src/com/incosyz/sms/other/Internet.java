/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 15, 2015 Time : 12:54:11 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Internet {

    public static boolean isInternetAvailable() {
        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress("www.google.com", 80);
        try {
            socket.connect(address);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {

            }
        }
    }
}
