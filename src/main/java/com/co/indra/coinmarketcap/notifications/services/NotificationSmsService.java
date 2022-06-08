package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.apiTwillio.apiClient.SmsSender;
import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.notifications.model.entities.NotificationsData;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationDataRepository;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationSmsService {

	@Autowired
	private NotificationsRepository notificationsUserRepository;
	@Autowired
	private NotificationDataRepository notificationsDataRepository;

	@Autowired
	private SmsSender sendSMS;

	public void createSMSNotification(NotificationsData notifications) {
		if (notificationsUserRepository.findPhoneByIdUser(notifications.getIdUser()).isEmpty()) {
			throw new NotFoundException(ErrorCodes.USER_NOT_FOUND);
		}

		sendSMS.sendSms(notificationsUserRepository.findPhoneByIdUser(notifications.getIdUser()).get(0).getPhoneNumber(),
				notifications.getMessage(), notifications.getIdUser());
				notifications.setType("SMS");
				Date sentTo= new Date();
				notificationsDataRepository.saveNotificationData(notifications);

	}

}
