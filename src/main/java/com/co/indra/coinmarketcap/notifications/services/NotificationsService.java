package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.notifications.externalServices.EmailSend;
import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;


@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;
    @Autowired
    private UserNotificationsDataRepository userNotificationsDataRepository;
    @Autowired
    private EmailSend sendEmails;

    public void createEmailNotification(Notifications notifications) {
        if (userNotificationsDataRepository.findEmailByIdUser(notifications.getIdUser()).isEmpty()) {
            throw new NotFoundException(ErrorCodes.USER_NOT_FOUND);
        }
        try{
            sendEmails.sendEmails(notifications.getSubject(),notifications.getMessage(),userNotificationsDataRepository.findEmailByIdUser(notifications.getIdUser()).get(0).getMail());
        } catch (IOException e){
            throw new RuntimeException(e);
        }
		notifications.setType("MAIL");
		Date sentAt = new Date();
		notifications.setSentAt(sentAt);
		notificationsRepository.saveNotificationData(notifications);
    }

}
