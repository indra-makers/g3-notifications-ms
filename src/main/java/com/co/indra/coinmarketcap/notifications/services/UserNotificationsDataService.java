package com.co.indra.coinmarketcap.notifications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.indra.coinmarketcap.notifications.model.entities.NotificationUser;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;

@Service
public class UserNotificationsDataService {
	@Autowired
	private NotificationsRepository userNotificationsDataRepository;
	
	public void createNotificationUserData(NotificationUser userNotificationsData){
		userNotificationsDataRepository.createNotificationUserData(userNotificationsData);
	}
}
