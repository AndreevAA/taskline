package com.taskline.main.mail.entity;

public class MailConnectionProperties {
    String imapEmail;
    String imapPwd;
    String imapServer;
    String imapPort;

    public MailConnectionProperties(String imapEmail, String imapPwd, String imapServer, String imapPort) {
        this.imapEmail = imapEmail;
        this.imapPwd = imapPwd;
        this.imapServer = imapServer;
        this.imapPort = imapPort;
    }

    public MailConnectionProperties() {
    }

    public String getImapEmail() {
        return imapEmail;
    }

    public void setImapEmail(String imapEmail) {
        this.imapEmail = imapEmail;
    }

    public String getImapPwd() {
        return imapPwd;
    }

    public void setImapPwd(String imapPwd) {
        this.imapPwd = imapPwd;
    }

    public String getImapServer() {
        return imapServer;
    }

    public void setImapServer(String imapServer) {
        this.imapServer = imapServer;
    }

    public String getImapPort() {
        return imapPort;
    }

    public void setImapPort(String imapPort) {
        this.imapPort = imapPort;
    }
}
