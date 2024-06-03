package com.miraeasset.biz.common.util.mail;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

@Service
public class MailUtil {

    private Properties properties = System.getProperties();
    @Value("${mail.smtp.host}")
    private String defaultHost;
    @Value("${mail.smtp.port}")
    private String defaultPort;
    @Value("${mail.smtp.starttls.enable}")
    private String defaultStarttlsEnable;
    @Value("${mail.smtp.auth}")
    private String defaultAuth;


    public MailUtil() {

    }

    public MailUtil(Properties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void setDefaultProperties() {
        this.properties.put("mail.smtp.host", defaultHost);
        this.properties.put("mail.smtp.port", defaultPort);
        this.properties.put("mail.smtp.starttls.enable", defaultStarttlsEnable);
        this.properties.put("mail.smtp.auth", defaultAuth);

//        this.properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        this.properties.put("mail.smtp.ssl.trust", "*");
        this.properties.put("mail.protocol.ssl.trust", "*");
        this.properties.put("mail.smtp.ssl.checkserveridentity", false);
//        this.properties.put("mail.smtp.ssl")
    }

    public String sendMail(String sendId, String sendPw, String receiveId, String subject, String content) {
        String result = "success";

        try {
            Authenticator authenticator = new MailAuthUtil(sendId, sendPw);
            Session session = Session.getInstance(this.properties, authenticator);
            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setSentDate(new Date());
            mimeMessage.setFrom(new InternetAddress(sendId));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveId));
            mimeMessage.setSubject(subject, "UTF-8");
            mimeMessage.setContent(content, "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            result = e.toString();
        } catch (Exception e) {
            e.printStackTrace();
            result = e.toString();
        }
        return result;
    }

    public String sendMailWtihWorkBook(String sendId, String sendPw, String receiveId, String subject, String content
            , Workbook workbook, String fileName) {

        String result = "success";

        try {
            Authenticator authenticator = new MailAuthUtil(sendId, sendPw);
            Session session = Session.getInstance(this.properties, authenticator);
            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setSentDate(new Date());
            mimeMessage.setFrom(new InternetAddress(sendId));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveId));
            mimeMessage.setSubject(subject, "UTF-8");

            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html; charset=UTF-8");
            multipart.addBodyPart(mimeBodyPart);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                workbook.write(byteArrayOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            DataSource dataSource = new ByteArrayDataSource(byteArrayOutputStream.toByteArray()
                    , "application/vnd.ms-excel");

            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.setFileName(MimeUtility.encodeText(fileName, "UTF-8", "B"));
            attachPart.setDataHandler(new DataHandler(dataSource));

            multipart.addBodyPart(attachPart);
            mimeMessage.setContent(multipart);

            Transport.send(mimeMessage);

        } catch (AddressException e) {
            e.printStackTrace();
            result = e.toString();

        } catch (MessagingException e) {
            e.printStackTrace();
            result = e.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            result = e.toString();
        }

        return result;
    }

    public String sendMailWithFiles(String sendId, String sendPw, String receiveId, String subject, String content, List<String> filePathList) {
        String result = "success";

        try {
            Authenticator authenticator = new MailAuthUtil(sendId, sendPw);
            Session session = Session.getInstance(this.properties, authenticator);
            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setSentDate(new Date());
            mimeMessage.setFrom(new InternetAddress(sendId));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveId));
            mimeMessage.setSubject(subject, "UTF-8");

            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html; charset=UTF-8");
            multipart.addBodyPart(mimeBodyPart);

            if(filePathList != null && filePathList.size() > 0) {
                for(String filePath : filePathList) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    DataSource dataSource = new FileDataSource(filePath);
                    attachPart.setDataHandler(new DataHandler(dataSource));
                    try {
                        attachPart.setFileName(MimeUtility.encodeText(dataSource.getName(), "UTF-8", "B"));
                        multipart.addBodyPart(attachPart);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        result = "fail";
                    }
                }
            }

            mimeMessage.setContent(multipart);
            Transport.send(mimeMessage);

        } catch (Exception ex) {
            result = ex.getMessage();
        }

        return result;
    }

}
