/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.pdfcontroller;

import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.other.CurrancyFormat;
import com.incosyz.sms.other.MailSender;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

/**
 * Date : Nov 15, 2015 Time : 5:15:30 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class OrderPDF {

    public void printPdf(ArrayList<GETOrderModel> gETOrderModels) {

    }

    public void sendPdf(ArrayList<GETOrderModel> gETOrderModels, String orderDescription) throws DocumentException, MessagingException {
        try {
            String html = getHTML(gETOrderModels, orderDescription);

            Document document = new Document(PageSize.A4.rotate());

            String path = "./src/com/incosyz/sms/temp/tmporders.pdf";
            File f = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);

            document.open();

            StringReader fileReader = new StringReader(html);
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, fileReader);

            document.close();
            fileOutputStream.close();

            MailSender mailSender = new MailSender();
            MimeBodyPart body = (MimeBodyPart) mailSender.getBody();
            body.setText(html, "utf-8", "html");
            mailSender.setAttachmentPath(path);
            mailSender.setSubject(orderDescription);
            mailSender.sendMail();
        } catch (IOException ex) {
            Logger.getLogger(OrderPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generateOrderPdf(ArrayList<GETOrderModel> gETOrderModels, String filepath, String orderDescription) throws FileNotFoundException, DocumentException {
        try {
            String html = getHTML(gETOrderModels, orderDescription);

            Document document = new Document(PageSize.A4.rotate());

            File f = new File(filepath);
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);

            document.open();

            StringReader fileReader = new StringReader(html);
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, fileReader);

            document.close();
            fileOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTML(ArrayList<GETOrderModel> gETOrderModels, String orderDescription) throws FileNotFoundException, IOException {

        String html = "<html>"
                + "    <head>"
                + "        <style type='text/css'>";

        File file = new File("./src/com/incosyz/sms/css/ordersCss.css");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while (line != null) {
            html += line;
            line = br.readLine();
        }

        html += "</style>"
                + "    </head>"
                + "    <body> ";

        html += "        <div class=\"top1\">\n"
                + "            Samagi Traders\n"
                + "        </div>\n"
                + "        <div class=\"top2\">\n"
                + "            Sales Management System - Orders Document\n<br/><br/>"
                + "        </div><br/><br/>";

        html += "    <table>"
                + "            <tr>"
                + "                <th>Round No</th>"
                + "                <th width='15%'>Model Name</th>"
                + "                <th width='15%'>Customer Name</th>"
                + "                <th>Order Amount (Rs)</th>"
                + "                <th>Cash Amount (Rs)</th>"
                + "                <th>Cheque Amount (Rs)</th>"
                + "                <th>Leasing Amount (Rs)</th>"
                + "                <th>Commision (Rs)</th>"
                + "                <th>Date</th>"
                + "            </tr>";

        double TotalAmount = 0;
        double TotalCash = 0;
        double TotalCheque = 0;
        double TotalLeasing = 0;
        double TotalCommision = 0;
        for (GETOrderModel gETOrderModel : gETOrderModels) {
            String roundNo = gETOrderModel.getOrderModel().getRoundNo();
            String modelNo = gETOrderModel.getModel().getModelName();
            String customerName = gETOrderModel.getCustomerModel().getCustomerName();
            String orderAmount = gETOrderModel.getOrderModel().getOrderAmount();

            double cash = 0;
            ArrayList<CashModel> cashModels = gETOrderModel.getCashModels();
            for (CashModel cashModel : cashModels) {
                cash += Double.parseDouble(cashModel.getCashAmount());
            }

            String leasingAmount = "0.00";
            if (gETOrderModel.getLeasingModel() != null) {
                leasingAmount = gETOrderModel.getLeasingModel().getLeasingAmount();
            }

            double cheque = 0;
            ArrayList<CheckModel> checkModels = gETOrderModel.getCheckModels();
            for (CheckModel checkModel : checkModels) {
                cheque += Double.parseDouble(checkModel.getAmount());
            }

            String commision = gETOrderModel.getPaymentModel().getCommision();
            String date = gETOrderModel.getOrderModel().getOrderDate();

            TotalAmount += Double.parseDouble(orderAmount);
            TotalCash += cash;
            TotalLeasing += Double.parseDouble(leasingAmount);
            TotalCheque += cheque;
            TotalCommision += Double.parseDouble(commision);

            html += "            <tr>"
                    + "                <td>" + roundNo + "</td>"
                    + "                <td width='15%'>" + modelNo + "</td>"
                    + "                <td width='15%'>" + customerName + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(orderAmount) + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(cash) + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(cheque) + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(leasingAmount) + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(commision) + "</td>"
                    + "                <td>" + date + "</td>"
                    + "            </tr>";

        }

        html += "            <tr class='bottomtr'>"
                + "                <td colspan='3' class='total'>Total</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(TotalAmount) + "</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(TotalCash) + "</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(TotalCheque) + "</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(TotalLeasing) + "</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(TotalCommision) + "</td>"
                + "                <td></td>"
                + "            </tr>";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        html += "</table>"
                + "<table>"
                + "<tr class='b'>"
                + "<td>Document Description | " + orderDescription + "</td>"
                + "<td>Date | " + dateFormat.format(new Date()) + "</td>"
                + "<td>Time | " + timeFormat.format(new Date()) + "</td>"
                + "<td>User | </td>"
                + "<td>Row Count | " + gETOrderModels.size() + "</td>"
                + "</tr>"
                + "</table>";
        html += "</body>"
                + "</html>";
        return html;
    }
}
