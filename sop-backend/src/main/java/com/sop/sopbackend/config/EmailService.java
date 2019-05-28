package com.sop.sopbackend.config;


import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
	
    public void sendEmail(String mail, String subject, String message) throws MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

        generateMailMessage.setSubject(subject);
        String emailBody = message;
        generateMailMessage.setContent(emailBody, "text/html");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "admtwinkle@gmail.com", "parola123twinkle");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

}