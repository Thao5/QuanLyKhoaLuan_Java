/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.utils;

import java.util.Properties;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.stereotype.Component;

/**
 *
 * @author Chung Vu
 */
@Component
public class MailUtil {

    private static final String chart = "abcdefghijklmnopqrstuvwxyz0123456789";
    public static final String ACCOUNT_SID = "AC0e1b830f7c1a7020bf1c9158586f5669";
    public static final String AUTH_TOKEN = "4f430a5a72fb16b0b44713f3c3899b5e";

    public void sendMail(String to, String subject, String text) {
        final String from = "kolotest54@gmail.com";
        String host = "smtp.gmail.com";
        final String password = "oehe ague lumt klgg";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            System.out.println("Failed");
            mex.printStackTrace();
        }

    }
}
