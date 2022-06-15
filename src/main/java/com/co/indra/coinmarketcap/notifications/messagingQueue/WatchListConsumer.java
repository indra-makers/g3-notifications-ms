package com.co.indra.coinmarketcap.notifications.messagingQueue;

import com.co.indra.coinmarketcap.notifications.messagingQueue.model.NotificationQueueBody;
import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.services.NotificationsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class WatchListConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationsService notificationsService;

    @RabbitListener(queues = "alert_notification_data")
    public void getNotificationQueue(String Notification){
        try {
            NotificationQueueBody notificationQueueBody = objectMapper.readValue(Notification, NotificationQueueBody.class);
            Notifications notifications = new Notifications();
            notifications.setType(notificationQueueBody.getType());
            notifications.setIdUser((long) notificationQueueBody.getUserId());
            notifications.setMessage(notificationQueueBody.getNotification().getBody());
            notifications.setSubject(notificationQueueBody.getNotification().getSubject());
            switch (notificationQueueBody.getType()){
                case "SMS": notificationsService.createSMSNotification(notifications);
                    break;
                case "MAIL": notificationsService.createMailNotification(notifications);
                    break;
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
