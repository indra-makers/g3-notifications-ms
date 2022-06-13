package com.co.indra.coinmarketcap.notifications.messaging;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserNotificationsDataService userNotificationsDataService;

    @RabbitListener(queues = "g3-users-ms")
    public void getUserQueue(String user){
        try {
            UserNotificationsData userNotificationsData = objectMapper.readValue(user, UserNotificationsData.class);
            userNotificationsDataService.createNotificationUserData(userNotificationsData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
