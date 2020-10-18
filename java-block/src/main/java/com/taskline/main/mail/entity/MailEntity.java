package com.taskline.main.mail.entity;

import java.time.LocalDateTime;
import java.util.List;

public class MailEntity {
    String emailFrom;
    List<String> emailTo;
    String emailText;
    String emailHeader;
    LocalDateTime receivedTime;

    public MailEntity(String emailFrom, List<String> emailTo, String emailText, String emailHeader, LocalDateTime receivedTime) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.emailText = emailText;
        this.emailHeader = emailHeader;
        this.receivedTime = receivedTime;
    }

    public String getEmailHeader() {
        return emailHeader;
    }

    public void setEmailHeader(String emailHeader) {
        this.emailHeader = emailHeader;
    }

    public MailEntity() {
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public List<String> getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(List<String> emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public LocalDateTime getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(LocalDateTime receivedTime) {
        this.receivedTime = receivedTime;
    }

    @Override
    public String toString() {
        return "MailEntity{" +
                "emailFrom='" + emailFrom + '\'' +
                ", emailTo=" + emailTo +
                ", emailText='" + emailText + '\'' +
                ", emailHeader='" + emailHeader + '\'' +
                ", receivedTime=" + receivedTime +
                '}';
    }
}
