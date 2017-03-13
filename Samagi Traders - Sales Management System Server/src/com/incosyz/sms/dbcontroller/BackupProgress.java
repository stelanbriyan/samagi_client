/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dbcontroller;

import com.incosyz.sms.db.DBConnection;
import com.incosyz.sms.file.FileWriteAccess;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INCOSYZ
 */
public class BackupProgress {

    private static String dbName;
    private static String host;
    private static String username;
    private static String password;

    private static void loadData() {
        dbName = "samagi";
        host = "localhost";
        username = "root";
        password = "mysql";
    }

    public static void main(String[] args) {
        try {
            writeBackup();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(BackupProgress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static byte[] writeBackup() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        loadData();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        String fileName = dateFormat.format(date) + "_SYSTEM_DUMP.bkp";

        String path = "./src/com/incosyz/sms/file/backup/" + fileName;
        Process runtimeProcess = runtime.exec("mysqldump " + dbName + " -h " + host + " -u " + username + " -p" + password + " -r  " + path);
        System.out.println(path);
        int res = runtimeProcess.waitFor();

        FileWriteAccess access = new FileWriteAccess();
        byte[] backupFile = access.getBackupFile(fileName);
        return backupFile;
    }

    public static int restoreBackup(byte[] b) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        loadData();
        Connection con = null;
        String path = "./src/com/incosyz/sms/file/backupTemp.bkp";
        
        OutputStream os = new FileOutputStream(path);
        os.write(b);
        os.flush();
        os.close();

        try {
            con = DBConnection.getDBConnection().getConnection();
        } catch (MySQLSyntaxErrorException ex) {
            if (ex.getMessage().equals("Unknown database 'samagi'")) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + host, username, password);
                String sql = "create database " + dbName;
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
            }
        }
        String[] executeCmd = new String[]{"mysql", dbName, "--user=" + username, "--password=" + password, "-e", " source " + path};
        //String executeCmd = "mysql Company --user=root --p=mysql -e source "+path ;
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }
}
