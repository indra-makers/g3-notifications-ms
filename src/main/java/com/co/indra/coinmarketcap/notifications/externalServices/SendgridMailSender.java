package com.co.indra.coinmarketcap.notifications.externalServices;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendgridMailSender {
    @Value("${api.mail.from}")
    private String apiMailFrom;

    @Value("${api.mail.key}")
    private String MAIL_KEY;

    public void sendEmails(String subject, String body, String sendTo) throws IOException {
        SendGrid sg = new SendGrid((MAIL_KEY));
        Request request = new Request();
        Email from = new Email(apiMailFrom);
        Email toMail = new Email(sendTo);
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