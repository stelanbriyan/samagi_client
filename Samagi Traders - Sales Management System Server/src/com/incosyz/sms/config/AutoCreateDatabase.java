/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.config;

import com.incosyz.sms.db.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INCOSYZ
 */
public class AutoCreateDatabase {

    private static int result;

    public static boolean create() throws SQLException, FileNotFoundException, IOException {
        try {
//            Configuration configuration = Configuration.load();
            String dbName = "samagi";
            String host = "localhost";
            String username = "root";
            String password = "mysql";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host, username, password);
            String sql = "create database " + dbName;
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            if (res > 0) {
                File file = new File("./src/com/incosyz/sms/config/samagi.sql");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                Connection conn = DBConnection.getDBConnection().getConnection();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    Statement statement = conn.createStatement();
                    result += statement.executeUpdate(line);
                }
            }
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(AutoCreateDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 15 <= result;
    }
}
