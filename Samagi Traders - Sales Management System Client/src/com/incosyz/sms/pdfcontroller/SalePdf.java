/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.pdfcontroller;

import com.incosyz.sms.mixmodel.GETOrderModel;
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
import javax.mail.MessagingException;

/**
 * Date : Nov 19, 2015 Time : 1:58:44 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class SalePdf {

    GETOrderModel gETOrderModel;
    private File f;

    public SalePdf(GETOrderModel gETOrderModel) {
        this.gETOrderModel = gETOrderModel;
    }

    public void sendEmail() throws MessagingException, IOException, DocumentException {
        MailSender mailSender = new MailSender();
        mailSender.setSubject("");
        String path = "./src/com/incosyz/sms/temp/O" + gETOrderModel.getOrderModel().getOrderId() + ".pdf";
        mailSender.setAttachmentPath(createPdf(path));
        mailSender.sendMail();
        done();
    }

    public String createPdf(String pathTo) throws FileNotFoundException, DocumentException, IOException {
        String html = getHtml();
        Document document = new Document(PageSize.A3.rotate());

        String path = pathTo;
        f = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);

        document.open();

        StringReader fileReader = new StringReader(html);
        XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, fileReader);

        document.close();
        fileOutputStream.close();
        return path;
    }

    public void done() {
        if (f.isFile()) {
            f.delete();
        }
    }

    private String getHtml() throws FileNotFoundException, IOException {
        String html = "<html>"
                + "    <head>"
                + "        <style type='text/css'>";

//        File file = new File("./src/com/incosyz/sms/css/ordersCss.css");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader br = new BufferedReader(fileReader);
//
//        String line = "";
//        while (line != null) {
//            html += line;
//            line = br.readLine();
//        }
        html += "</style>"
                + "    </head>"
                + "    <body> ";

        html += "        <div class=\"top1\">\n"
                + "            Samagi Traders\n"
                + "        </div>\n"
                + "        <div class=\"top2\">\n"
                + "            Sales Management System - Orders Document\n<br/><br/>"
                + "        </div><br/><br/>";

        html += "</body>"
                + "</html>";
        return html;
    }
}
