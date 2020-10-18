package com.taskline.main.mail;

import com.taskline.main.mail.entity.MailConnectionProperties;
import com.taskline.main.mail.entity.MailEntity;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.util.MimeMessageParser;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class MailConnector {
    private String IMAP_AUTH_EMAIL;
    private String IMAP_AUTH_PWD;
    private String IMAP_Server;
    private String IMAP_Port;

    private Properties properties;
    private Session session;

    public MailConnector(MailConnectionProperties mailConnection) {
        IMAP_AUTH_EMAIL = mailConnection.getImapEmail();
        IMAP_AUTH_PWD = mailConnection.getImapPwd();
        IMAP_Server = mailConnection.getImapServer();
        IMAP_Port = mailConnection.getImapPort();

        properties = new Properties();
        properties.put("mail.debug", "false");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.port", IMAP_Port);

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailConnection.getImapEmail(), mailConnection.getImapPwd());
            }
        };

        session = Session.getDefaultInstance(properties, auth);
        session.setDebug(false);
    }

    public List<MailEntity> getMessages() {
        try {
            Store store = session.getStore();

            // Подключение к почтовому серверу
            store.connect(IMAP_Server, IMAP_AUTH_EMAIL, IMAP_AUTH_PWD);

            // Папка входящих сообщений
            Folder inbox = store.getFolder("INBOX");

            // Открываем папку в режиме только для чтения
            inbox.open(Folder.READ_WRITE);

            //System.out.println("Количество сообщений : " + String.valueOf(inbox.getMessageCount()));
            if (inbox.getMessageCount() == 0) {
                return null;
            }

            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.ANSWERED), false);
            Message[] messages = inbox.search(ft);

//            Message message = inbox.getMessage(inbox.getMessageCount());
            System.out.println("New messages {}" + messages.length);
            List<MailEntity> entityList = new ArrayList<>();
            Arrays.asList(messages).forEach(message -> {
                try {
                    System.out.println("Message type: {} {}" + message.getContentType() + message.getContent().toString());
                    if (message.getContent() != null) {
                        String htmlContent = new MimeMessageParser((MimeMessage) message).parse().getPlainContent();
                        entityList.add(new MailEntity(message.getFrom()[0].toString(), Collections.singletonList("NULL"), message.getSubject(), htmlContent, message.getSentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
//                        content.append("Пришло письмо").append("\n")
//                                .append("От: ").append(message.getFrom()[0].toString()).append("\n")
//                                .append("Тема: ").append(message.getSubject()).append("\n")
//                                .append("Содержание: ").append(htmlContent.trim());
                        message.setFlag(Flags.Flag.SEEN, true);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            inbox.close(false);
            store.close();

            return entityList;

        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }
}
