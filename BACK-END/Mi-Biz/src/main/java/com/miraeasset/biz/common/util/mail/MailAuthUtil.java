package com.miraeasset.biz.common.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthUtil extends Authenticator {
    PasswordAuthentication passwordAuthentication;

    public MailAuthUtil(String sendId, String sendPw) {
        this.passwordAuthentication = new PasswordAuthentication(sendId, sendPw);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return this.passwordAuthentication;
    }
}
