package com.co.indra.coinmarketcap.notifications.services;


import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

     @Autowired
    private NotificationsRepository notificationsRepository;

/*
     public void registerNotification(String type, String message,Long id_user){

         notificationsRepository.createNotification(new Notifications(type,message,id_user));

     }*/

    public void registerNotification(Notifications notifications){

        notificationsRepository.createNotification(notifications);

    }



     public List<Notifications> getNotificationsByType(String type){

         return notificationsRepository.findByNotifications(type);
     }




}
