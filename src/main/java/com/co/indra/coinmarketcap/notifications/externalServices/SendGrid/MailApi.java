package com.co.indra.coinmarketcap.notifications.externalServices.SendGrid;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailApi {

    @Value("${api.mail.from}")
    private String fromMail;

    @Value("${api.mail.key}")
    private String API_KEY;

    public void sendMail(String subject, String body, String to) throws IOException {
        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        Email from = new Email(fromMail);
        Email toMail = new Email(to);
        Content content = new Content("text/plain",body);
        Mail mail = new Mail(from, subject, toMail, content);
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        try{
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            throw ex;
        }
    }
}
