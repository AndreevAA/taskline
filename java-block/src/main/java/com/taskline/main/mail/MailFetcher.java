package com.taskline.main.mail;

import com.taskline.main.mail.entity.MailConnectionProperties;
import com.taskline.main.mail.entity.MailEntity;

import java.util.List;

public class MailFetcher {

    // TODO scheduled ?

    public static List<MailEntity> fetchFromMailRu(String email, String password) {
        MailConnectionProperties properties = new MailConnectionProperties(email, password, "imap.mail.ru", "993");
        MailConnector mailConnector = new MailConnector(properties);
        return mailConnector.getMessages();
    }

}
