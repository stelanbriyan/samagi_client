/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.dbcontroller.IdController;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Manoj Madushanka
 * @since 2015-06-18
 * @version 1.0
 */
public class IDGenerator {

    public static String getNewId(String tableName, String columnName, String prefix, int digitCount) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, columnName);
        if (prefix != null) {
            if (lastId != null) {
                int id = Integer.parseInt(lastId.split(prefix)[1]);
                id++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(digitCount);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(id);
                return prefix + newID;
            } else {
                String id = prefix;
                for (int i = 0; i < digitCount - 1; i++) {
                    id = id.concat("0");
                }
                return id.concat("1");
            }
        } else {
            if (lastId != null) {
                int id = Integer.parseInt(lastId);
                id++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(digitCount);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(id);
                return newID;
            } else {
                String id = "";
                for (int i = 0; i < digitCount - 1; i++) {
                    id = id.concat("0");
                }
                return id.concat("1");
            }
        }
    }

    public static String getNewId(String tableName, String columnName, String prefix, int digitCount, String lastId) throws ClassNotFoundException, SQLException {
        if (prefix != null) {
            if (lastId != null) {
                int id = Integer.parseInt(lastId.split(prefix)[1]);
                id++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(digitCount);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(id);
                return prefix + newID;
            } else {
                String id = prefix;
                for (int i = 0; i < digitCount - 1; i++) {
                    id = id.concat("0");
                }
                return id.concat("1");
            }
        } else {
            if (lastId != null) {
                int id = Integer.parseInt(lastId);
                id++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(digitCount);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(id);
                return newID;
            } else {
                String id = "";
                for (int i = 0; i < digitCount - 1; i++) {
                    id = id.concat("0");
                }
                return id.concat("1");
            }
        }
    }
}
