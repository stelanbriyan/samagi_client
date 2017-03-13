/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Date : Nov 20, 2015 Time : 8:12:01 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class UploadBackup {

    public static void uploadBackup(String filePath , String fileName) {
        String server = "ftp.bambooblindslanka.com";
        int port = 21;
        String user = "samagi@bambooblindslanka.com";
        String pass = "fs82xKzHZvtU";

        FTPClient client = new FTPClient();
        try {
            client.connect(server, port);
            client.login(user, pass);
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);
            File firstLocalFile = new File(filePath);

            String firstRemoteFile = fileName;
            InputStream inputStream = new FileInputStream(firstLocalFile);
            
            boolean done = client.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(UploadBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
