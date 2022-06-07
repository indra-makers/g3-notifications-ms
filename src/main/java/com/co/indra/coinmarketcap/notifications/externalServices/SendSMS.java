package com.co.indra.coinmarketcap.notifications.externalServices;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendSMS {
    @Value("${sms.acc.sid}")
    private String ACCOUNT_SID;
    @Value("${sms.auth.token}")
    private String AUTH_TOKEN;
    @Value("${sms.phone.from}")
    private String FROM;

    public void sendsms(String p, String m, Long u) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(p),
                        new com.twilio.type.PhoneNumber(FROM),
                        "Hola "+u+"\n"+m)
                .create();

    }
}
