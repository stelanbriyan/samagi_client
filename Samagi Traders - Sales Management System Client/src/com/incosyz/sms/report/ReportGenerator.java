/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.report;

import java.awt.Container;
import java.sql.Connection;
import java.util.Map;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Date : Nov 24, 2015 Time : 12:27:18 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ReportGenerator {

    public static String REPORT_PATH = "./src/com/incosyz/sms/report/";

    public static Container generateReport(String reportName, TableModel tableModel, Map<String, Object> parameterMap, Connection connection) throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport(REPORT_PATH + reportName + ".jrxml");
        JasperPrint jasperPrint;
        if (tableModel == null) {
            if (connection == null) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap);
            } else {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, connection);
            }
        } else {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, new JRTableModelDataSource(tableModel));
        }
        return new JasperViewer(jasperPrint).getContentPane();
    }

    public static Container generateReport(JasperReport jasperReport, TableModel tableModel, Map<String, Object> parameterMap, Connection connection) throws JRException {
        JasperPrint jasperPrint;
        if (tableModel == null) {
            if (connection == null) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap);
            } else {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, connection);
            }
        } else {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, new JRTableModelDataSource(tableModel));
        }
        return new JasperViewer(jasperPrint).getContentPane();
    }
}
