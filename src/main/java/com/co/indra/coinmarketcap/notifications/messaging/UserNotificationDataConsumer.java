package com.co.indra.coinmarketcap.notifications.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserNotificationDataConsumer {

   @Autowired
   private ObjectMapper objectMapper;

   @Autowired
   private UserNotificationsDataService userNotificationsDataService;

   @RabbitListener(queues = "user_notification_data")
   public void listenerTestQueue(String mensaje) {

      try {
         UserNotificationsData userData = objectMapper.readValue(mensaje, UserNotificationsData.class);
         userNotificationsDataService.createDataUser(userData.getIdUser(), userData.getMail(),
               userData.getPhoneNumber());
      } catch (JsonProcessingException exc) {
         exc.printStackTrace();
      }

   }

}
