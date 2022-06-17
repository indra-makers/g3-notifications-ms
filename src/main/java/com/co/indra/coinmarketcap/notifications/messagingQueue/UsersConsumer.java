package com.co.indra.coinmarketcap.notifications.messagingQueue;

import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserNotificationsDataService userNotificationsDataService;

    @RabbitListener(queues = "user_notification_data")
    public void getUserQueue(String user){
        try {
            UserNotificationsData userNotificationsData = objectMapper.readValue(user, UserNotificationsData.class);
            userNotificationsDataService.createNotificationUserData(userNotificationsData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
