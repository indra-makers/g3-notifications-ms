package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationsDataRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotificationsDataService {

	@Autowired
	private UserNotificationsDataRepository userNotificationsDataRepository;

	public void createNotificationUserData(UserNotificationsData userNotificationsData){
		userNotificationsDataRepository.createNotificationUserData(userNotificationsData);
	}

}
