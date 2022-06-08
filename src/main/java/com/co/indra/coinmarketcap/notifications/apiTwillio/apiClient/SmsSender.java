package com.co.indra.coinmarketcap.notifications.apiTwillio.apiClient;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {
	@Value("${sms.account.sid}")
	private String ACCOUNT_SID;
	@Value("${sms.auth.token}")
	private String AUTH_TOKEN;
	@Value("${sms.phone.from}")
	private String FROM;

	public void sendSms(String phoneUser, String messageSent, Long idUser) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber(phoneUser), 
							new com.twilio.type.PhoneNumber(FROM), 
							"Hola hermana calva " + idUser + "\n" + messageSent)
							.create();
	}
}
