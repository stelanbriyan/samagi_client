/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.clientcontroller.BackupControllerImplClient;
import com.incosyz.sms.config.ValueProperty;
import com.incosyz.sms.view.Backup;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 20, 2015 Time : 4:17:00 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class AutoBackup {

    public void backupToCloud() {
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    if (Internet.isInternetAvailable()) {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String format = dateFormat.format(new Date());
                        try {
                            byte[] writeBackup = BackupControllerImplClient.writeBackup();

                            String filePath = "./src/com/incosyz/sms/backup/" + format + "_CLOUD.bkp";
                            OutputStream os = new FileOutputStream(filePath);
                            os.write(writeBackup);
                            os.flush();
                            os.close();

                            UploadBackup.uploadBackup(filePath, format + ".bkp");

                            File f = new File(filePath);
                            if (f.isFile()) {
                                f.delete();
                            }
                        } catch (NotBoundException | ClassNotFoundException | MalformedURLException | SQLException | RemoteException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        ValueProperty property = null;
                        try {
                            property = new ValueProperty();
                            property.setProperty("AUTO_BACKUP_CLOUD", format);
                        } catch (IOException ex) {
                            Logger.getLogger(AutoBackup.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutoBackup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();
    }

    public void createAutoDirectoryBackup() {

        new Thread() {

            @Override
            public void run() {
                try {
                    ValueProperty property = null;
                    try {
                        property = new ValueProperty();
                    } catch (IOException ex) {
                        Logger.getLogger(AutoBackup.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String dateBackup = property.getProperty("AUTO_BACKUP");

                    Date d = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String format = dateFormat.format(d);

                    if (!format.equals(dateBackup)) {
                        try {
                            byte[] writeBackup = BackupControllerImplClient.writeBackup();

                            String filePath = "./src/com/incosyz/sms/backup/" + format + ".bkp";
                            OutputStream os = new FileOutputStream(filePath);
                            os.write(writeBackup);
                            os.flush();
                            os.close();

                        } catch (NotBoundException | ClassNotFoundException | MalformedURLException | SQLException | RemoteException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        property.setProperty("AUTO_BACKUP", format);
                    }
                } catch (Exception e) {

                }
            }

        }.start();

    }
}
