package com.co.indra.coinmarketcap.notifications.externalServices;

import com.co.indra.coinmarketcap.notifications.externalServices.sendgrid.SenderSendGridMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailSenderService {
    @Autowired
    private SenderSendGridMail senderSendGridMail;

    public void sendMail(String subject, String body, String to){
        try {
            senderSendGridMail.sendMail(subject, body, to);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

