package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.model.requests.NotificationsDataRequest;
import com.co.indra.coinmarketcap.notifications.services.NotificationsService;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.co.indra.coinmarketcap.notifications.config.Routes;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATIONS_PATH)
public class NotificationsController {

	@Autowired
	private NotificationsService notificationsService;

	@Autowired
	private UserNotificationsDataService userNotificationsDataService;

	/******** Comienzo de controladores para entidad Notifications */

	@PostMapping
	public void createUserData(@RequestBody UserNotificationsData userNotificationsData) {
		userNotificationsDataService.createNotificationUserData(userNotificationsData);
	}

	@PostMapping(Routes.SEND_SMS_PATH)
	public void sendSMS(@RequestBody Notifications notifications){
		notificationsService.createSMSNotification(notifications);
	}
	@PostMapping(Routes.SEND_MAIL_PATH)
	public void CreateMail(@RequestBody Notifications notifications){
		notificationsService.createMailNotification(notifications);

	}

	// Obtener notificaciones por tipo de notificacion
	@GetMapping
	public List<Notifications> getNotificationsByType(@RequestParam(name = "searchnotification") String type) {
		return null;
	}

	// Obtener notificaciones por el id de la notificacion
	@GetMapping(Routes.NOTIFICATION_BY_ID)
	public List<Notifications> getNotificationsByIdNotifications(@PathVariable("idNotifications") Long idNotifications) {
		return null;
	}

	// Eliminar notificacion por medio del id de notificacion
	@DeleteMapping(Routes.NOTIFICATION_BY_ID)
	public void removenotification(@PathVariable("idNotifications") Long idNotifications) {

	}
	

	/****************
	 * Comienzo de controladores para entidad UserNotificationData
	 **/

	// Agregar a una notificacion sus datos de envio
	@PostMapping(Routes.ADD_INFO_TO_NOTIFY)
	public void createDataToNotification(@RequestBody NotificationsDataRequest request,
			@PathVariable("idNotifications") Long idNotifications) {

	}

	// Obtener los datos de envio segun el id de la notificacion suministrada por la
	// URL
	@GetMapping(Routes.ADD_INFO_TO_NOTIFY)
	public List<UserNotificationsData> getNotificationDataByIdNotification(
			@PathVariable("idNotifications") Long idNotifications) {
		return null;
	}

	// Eliminar los datos de envio por medio del id Notifications FK
	@DeleteMapping(Routes.ADD_INFO_TO_NOTIFY)
	public void removeUserDataByIdNotifications(@PathVariable("idNotifications") Long id_notifications) {

	}

}
