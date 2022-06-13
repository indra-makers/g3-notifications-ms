package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.notifications.externalServices.SMSSenderService;
import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;
    @Autowired
    private UserNotificationsDataRepository userNotificationsDataRepository;
    @Autowired
    private SMSSenderService SMSSenderService;

    public void createSMSNotification(Notifications notifications) {
        if (userNotificationsDataRepository.findPhoneByIdUser(notifications.getIdUser()).isEmpty()) {
            throw new NotFoundException(ErrorCodes.USER_NOT_FOUND);
        }
        notifications.setSentTo(userNotificationsDataRepository.findPhoneByIdUser(notifications.getIdUser()).get(0).getPhoneNumber());
        SMSSenderService.sendSMS(notifications);
		notifications.setType("SMS");
		Date sentAt = new Date();
		notifications.setSentAt(sentAt);
		notificationsRepository.saveNotificationData(notifications);
    }

}
