package com.example.TenderBidding.services;

import jakarta.mail.*; // Измените этот импорт
import jakarta.mail.internet.*; // Измените этот импорт
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final String username = "artur.b3lsh@yandex.ru"; // Ваш email
    private final String password = "dpcjrlakrluaexhz"; // Ваш пароль

    public void sendEmail(String recipientEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() { // Измените этот импорт
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
