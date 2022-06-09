package com.co.indra.coinmarketcap.notifications.externalServices;

import com.co.indra.coinmarketcap.notifications.externalServices.SendGrid.MailApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Sender {

    @Autowired
    private MailApi mailApi;

    public void sendMail(String subject, String body, String to) throws IOException {
        mailApi.sendMail(subject,body,to);
    }
}
