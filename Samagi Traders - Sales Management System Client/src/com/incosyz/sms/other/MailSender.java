/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.config.Setting;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Date : Nov 15, 2015 Time : 10:19:55 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class MailSender {

    private String to;

    private String from;

    private String userName;
    private String myPassword;

    private String smtp = "Smtp.gmail.com";

    private String attachmentPath;
    private BodyPart messageBodyPart;
    private String subject;

    public MailSender() throws MessagingException, IOException {
        Setting s = new Setting();
        to = s.getProperty("EMAIL");

        from = "samagitvs@gmail.com";
        userName = "samagitvs";
        myPassword = "samagi578951";

        attachmentPath = "";

        subject = "CHEUQUE 323";

        messageBodyPart = new MimeBodyPart();

        // Create the message part
        // Now set the actual message
        messageBodyPart.setText("No Message Body !");

    }

    public void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, myPassword);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(getSubject());

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            if (attachmentPath != null) {
                messageBodyPart = new MimeBodyPart();
                String filename = attachmentPath;
                DataSource source = new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(filename);
                multipart.addBodyPart(messageBodyPart);
            } else {

            }

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the smtp
     */
    public String getSmtp() {
        return smtp;
    }

    /**
     * @param smtp the smtp to set
     */
    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    /**
     * @return the attachmentPath
     */
    public String getAttachmentPath() {
        return attachmentPath;
    }

    /**
     * @param attachmentPath the attachmentPath to set
     */
    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public BodyPart getBody() {
        return messageBodyPart;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
