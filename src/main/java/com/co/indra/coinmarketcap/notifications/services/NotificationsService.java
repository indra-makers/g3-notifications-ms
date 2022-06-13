package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.notifications.externalServices.SMSSenderService;
import com.co.indra.coinmarketcap.notifications.externalServices.MailApi;
import com.co.indra.coinmarketcap.notifications.externalServices.Sender;
import com.co.indra.coinmarketcap.notifications.externalServices.MailSender;
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
    private SMSSenderService SMSSenderService;

    private MailApi mailApi;

    private Sender mailApi;

    private MailSender mailApi;




    public void createMailNotification(Notifications notifications) {
        if (userNotificationsDataRepository.findMailByIdUser(notifications.getIdUser()).isEmpty()) {
            throw new NotFoundException(ErrorCodes.USER_NOT_FOUND);
        }
        notifications.setSentTo(userNotificationsDataRepository.findPhoneByIdUser(notifications.getIdUser()).get(0).getPhoneNumber());
        SMSSenderService.sendSMS(notifications);
		notifications.setType("SMS");
        try{
            mailApi.sendMail(notifications.getSubject(), notifications.getMessage(), userNotificationsDataRepository.findMailByIdUser(notifications.getIdUser()).get(0).getMail());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notifications.setType("MAIL");
		Date sentAt = new Date();
		notifications.setSentAt(sentAt);
		notificationsRepository.saveNotificationData(notifications);
    }

}
