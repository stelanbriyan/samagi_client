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
public class ChequePDF {

    public void printPdf(ArrayList<GETOrderModel> gETOrderModels) {

    }

    public void sendPdf(ArrayList<CheckModel> checkModels, String chequeDescription) throws DocumentException, MessagingException {
        try {
            
            
            
            String html = getHTML(checkModels, chequeDescription);

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
            mailSender.setSubject(chequeDescription);
            mailSender.sendMail();
        } catch (IOException ex) {
            Logger.getLogger(ChequePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generateOrderPdf(ArrayList<CheckModel> checkModels, String filepath, String chequeDescription) throws FileNotFoundException, DocumentException {
        try {
            String html = getHTML(checkModels, chequeDescription);

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
            Logger.getLogger(ChequePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTML(ArrayList<CheckModel> checkModels, String chequeDescription) throws FileNotFoundException, IOException {

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
                + "                <th>Cheque No</th>"
                + "                <th width='15%'>BankName</th>"
                + "                <th width='15%'>Pay</th>"
                + "                <th>Amount</th>"
                + "                <th>Date</th>"
                + "                <th>Type</th>"
                + "                <th>State</th>"
                + "                <th>Note</th>"
                + "            </tr>";

        double totalAmount = 0;
        for (CheckModel checkModel : checkModels) {
            String chequeNo = checkModel.getCheckNo() == null ? "" : checkModel.getCheckNo();
            String bankName = checkModel.getBankName()== null ? "" : checkModel.getBankName();
            String pay = checkModel.getIssuedBy()== null ? "" : checkModel.getIssuedBy();
            String amount = checkModel.getAmount()== null ? "" : checkModel.getAmount();
            String date = checkModel.getChequeDate()== null ? "" : checkModel.getChequeDate();
            String type = checkModel.getType()== null ? "" : checkModel.getType();
            String state = checkModel.getStateName()== null ? "" : checkModel.getStateName();
            String note = checkModel.getNote()== null ? "" : checkModel.getNote();

            totalAmount += Double.parseDouble(amount);

            html += "            <tr>"
                    + "                <td>" + chequeNo + "</td>"
                    + "                <td width='15%'>" + bankName + "</td>"
                    + "                <td width='15%'>" + pay + "</td>"
                    + "                <td>" + CurrancyFormat.getCurrancyFormat(amount) + "</td>"
                    + "                <td>" + date + "</td>"
                    + "                <td>" + type + "</td>"
                    + "                <td>" + state + "</td>"
                    + "                <td>" + note + "</td>"
                    + "            </tr>";

        }

        html += "            <tr class='bottomtr'>"
                + "                <td colspan='3' class='total'>Total</td>"
                + "                <td>" + CurrancyFormat.getCurrancyFormat(totalAmount) + "</td>"
                + "                <td  colspan='4'></td>"
                + "            </tr>";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        html += "</table>"
                + "<table>"
                + "<tr class='b'>"
                + "<td>Document Description | " + chequeDescription + "</td>"
                + "<td>Date | " + dateFormat.format(new Date()) + "</td>"
                + "<td>Time | " + timeFormat.format(new Date()) + "</td>"
                + "<td>User | </td>"
                + "<td>Row Count | " + checkModels.size() + "</td>"
                + "</tr>"
                + "</table>";
        html += "</body>"
                + "</html>";
        return html;
    }
}
