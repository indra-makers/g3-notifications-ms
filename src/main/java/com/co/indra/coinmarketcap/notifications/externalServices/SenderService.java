package com.co.indra.coinmarketcap.notifications.externalServices;

import com.co.indra.coinmarketcap.notifications.externalServices.twilio.SenderTwilioSMS;
import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderService {
    @Autowired
    private SenderTwilioSMS senderTwilioSMS;

    public void sendSMS(Notifications notifications){
        senderTwilioSMS.sendsms(notifications.getSentTo(), notifications.getMessage(), notifications.getIdUser());
    }
}
