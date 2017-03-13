
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.mixmodel.GETOrderModel;
import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.HomePhoneModel;
import com.incosyz.sms.model.MobileModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

/**
 * Date : Nov 15, 2015 Time : 3:36:36 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SendOrderMail {

    public void savePdf(GETOrderModel gETOrderModel, String savePath) throws IOException, DocumentException {
        String html = getHTML(gETOrderModel);
        File file = new File("./src/com/incosyz/sms/temp/" + gETOrderModel.getOrderModel().getOrderId() + ".html");
//            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(html);
        bw.close();

        Document d = new Document(PageSize.A4);
        String filePath = savePath + ".pdf";

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        PdfWriter pdfWriter = PdfWriter.getInstance(d, fileOutputStream);

        d.addAuthor("Incosyz");
        d.addTitle("Sale Detail");
        d.addTitle("Sale Detail");

        d.open();

        FileInputStream fileInputStream = new FileInputStream(file);
        XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, d, fileInputStream);

        d.close();
        fileOutputStream.close();
        
        if (file.isFile()) {
            file.delete();
        }
        
        
    }

    public void sendOrder(GETOrderModel gETOrderModel, String txt ) throws IOException, MessagingException {
        try {
            String html = getHTML(gETOrderModel);
            File file = new File("./src/com/incosyz/sms/temp/" + gETOrderModel.getOrderModel().getOrderId() + ".html");
//            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(html);
            bw.close();

            Document d = new Document(PageSize.A4);
            String filePath = "./src/com/incosyz/sms/temp/" + gETOrderModel.getOrderModel().getOrderId() + ".pdf";

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            PdfWriter pdfWriter = PdfWriter.getInstance(d, fileOutputStream);

            d.addAuthor("Incosyz");
            d.addTitle("Sale Detail");
            d.addTitle("Sale Detail");

            d.open();

            FileInputStream fileInputStream = new FileInputStream(file);
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, d, fileInputStream);

            d.close();
            fileOutputStream.close();

            MailSender mailSender = new MailSender();
            MimeBodyPart body = (MimeBodyPart) mailSender.getBody();
            body.setText("");
            mailSender.setSubject(txt + " Sale Detail Round No : " + gETOrderModel.getOrderModel().getRoundNo() + "  | Order Amount : Rs " + CurrancyFormat.getCurrancyFormat(gETOrderModel.getOrderModel().getOrderAmount()));
            mailSender.setAttachmentPath(filePath);
            mailSender.sendMail();

            if (file.isFile()) {
                File f = new File(filePath);
                f.delete();
                file.delete();
            }

        } catch (DocumentException ex) {
            Logger.getLogger(SendOrderMail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getHTML(GETOrderModel gETOrderModel) throws FileNotFoundException, IOException {
        String html = "<html><head><style type='text/css' media='all'>";

        File file = new File("./src/com/incosyz/sms/css/ordercss.css");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while (line != null) {
            html += line;
            line = br.readLine();
        }

        String roundNo = gETOrderModel.getStockModel().getRoundNo();
        String modelName = gETOrderModel.getModel().getModelName();

        String orderAmount = gETOrderModel.getOrderModel().getOrderAmount();
        String orderDate = gETOrderModel.getOrderModel().getOrderDate();

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

        double total = cheque + cash + Double.parseDouble(leasingAmount);

        String customerName = gETOrderModel.getCustomerModel().getCustomerName();
        String nic = gETOrderModel.getCustomerModel().getNicNo();
        String address = gETOrderModel.getCustomerModel().getAddressLineOne()
                + " " + gETOrderModel.getCustomerModel().getAddressLineTwo()
                + " " + gETOrderModel.getCustomerModel().getAddressLineThree();

        String mobile = "";
        ArrayList<MobileModel> mobileModels = gETOrderModel.getMobileModels();
        for (MobileModel mobileModel : mobileModels) {
            mobile += mobileModel.getMobileNo() + "<br/>";
        }

        String homeOffice = "";
        ArrayList<HomePhoneModel> homePhoneModels = gETOrderModel.getHomePhoneModels();
        for (HomePhoneModel homePhoneModel : homePhoneModels) {
            homeOffice += homePhoneModel.getHomePhoneNo() + "<br/>";
        }

        html += "</style></head><body>        <div class=\"has\">\n"
                + "            <div class=\"haa\">Samagi Traders - Sale Detail</div>\n"
                + "            <div class=\"hbb\">Sales Management System Vr 1.0</div>\n"
                + "        </div><br/><hr/><br/><div class=\"left\">\n"
                + "            <div class=\"a\">Round No    </div>\n"
                + "            <div class=\"b\">" + roundNo + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">Model Name    </div>\n"
                + "            <div class=\"b\">" + modelName + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">Order Amount    </div>\n"
                + "            <div class=\"b\">" + CurrancyFormat.getCurrancyFormat(orderAmount) + "</div><br/>\n"
                + "            \n"
                + "            <div class=\"a\">Order Date    </div>\n"
                + "            <div class=\"b\">" + orderDate + "</div><br/>\n"
                + "            \n"
                + "            <table width='100%'>\n"
                + "                <tr>\n"
                + "                    <td>Cash Amount</td>\n"
                + "                    <td>Rs " + CurrancyFormat.getCurrancyFormat(cash) + "</td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Leasing Amount</td>\n"
                + "                    <td>Rs " + CurrancyFormat.getCurrancyFormat(leasingAmount) + "</td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Cheque Amount</td>\n"
                + "                    <td>Rs " + CurrancyFormat.getCurrancyFormat(cheque) + "</td>\n"
                + "                </tr>\n "
                + "               <tr>\n"
                + "                    <th>Total</th>\n"
                + "                    <th>Rs " + CurrancyFormat.getCurrancyFormat(total) + "</th>\n"
                + "                </tr>\n"
                + "               <tr>\n"
                + "                    <th>Order Amount</th>\n"
                + "                    <th>Rs " + CurrancyFormat.getCurrancyFormat(orderAmount) + "</th>\n"
                + "                </tr>\n"
                + "            </table><br/><br/>"
                + "        </div>\n"
                + "        <div class=\"right\">\n"
                + "            <div class=\"a\">Customer Name    :</div>\n"
                + "            <div class=\"b\">" + customerName + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">NIC   :</div>\n"
                + "            <div class=\"b\">" + nic + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">Address   :</div>\n"
                + "            <div class=\"b\">" + address + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">Mobile   :</div>\n"
                + "            <div class=\"b\">" + mobile + "</div><br/>\n"
                + "\n"
                + "            <div class=\"a\">Home\\Office   :</div>\n"
                + "            <div class=\"b\">" + homeOffice + "</div><br/>\n"
                + "        </div>";

        if (gETOrderModel.getCheckModels() != null) {
            html += getChequeHtml(gETOrderModel.getCheckModels());
        }

        html += "<center>Copyright (c) Incosyz Solutions</center>";
        html += "</body></html>";

        return html;
    }

    private String getChequeHtml(ArrayList<CheckModel> checkModels) {
        String html = "<table class='myTable'><tr><th>Cheque No</th><th>Bank Name</th><th>Amount</th><th>Date</th><th>State</th></tr>";

        double total = 0;
        for (CheckModel checkModel : checkModels) {
            String stateName = checkModel.getStateName() == null ? "" : checkModel.getStateName();

            html += "<tr><td>"
                    + checkModel.getCheckNo() + "</td><td>"
                    + checkModel.getBankName() + "</td><td>Rs "
                    + CurrancyFormat.getCurrancyFormat(checkModel.getAmount()) + "</td><td>"
                    + checkModel.getChequeDate() + "</td><td>"
                    + stateName + "</td></tr>";

            total += Double.parseDouble(checkModel.getAmount());
        }

        html += "<tr><td></td><td>Total Amount</td><td>Rs " + CurrancyFormat.getCurrancyFormat(total) + "</td><td></td><td></td></tr>";

        html += "</table>";
        return html;
    }
}
