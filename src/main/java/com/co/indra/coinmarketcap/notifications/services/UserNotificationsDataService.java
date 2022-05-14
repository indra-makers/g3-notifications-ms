package com.co.indra.coinmarketcap.notifications.services;


import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationsDataService {

    @Autowired
    private UserNotificationsDataRepository userNotificationsDataRepository;

    public void registerUserNotificationData(UserNotificationsData userNotificationsData){

        userNotificationsDataRepository.createUserNotificationData(userNotificationsData);


    }



}
