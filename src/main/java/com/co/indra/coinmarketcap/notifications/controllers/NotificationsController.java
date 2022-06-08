package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.config.Routes;
import com.co.indra.coinmarketcap.notifications.model.entities.NotificationUser;
import com.co.indra.coinmarketcap.notifications.model.entities.NotificationsData;
import com.co.indra.coinmarketcap.notifications.model.requests.NotificationsDataRequest;
import com.co.indra.coinmarketcap.notifications.services.NotificationSmsService;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATIONS_PATH)
public class NotificationsController {

	@Autowired
	private NotificationSmsService notificationsDataService;

	@Autowired
	private UserNotificationsDataService notificationsUserService;

	/******** Comienzo de controladores para entidad Notifications */

	// Crear nueva notificacion
	@PostMapping
	public void createNotificationUser(@RequestBody NotificationUser notifications) {
		notificationsUserService.createNotificationUserData(notifications);
	}

	@PostMapping(Routes.SEND_SMS_PATH)
	public void CreateSMS(@RequestBody NotificationsData notifications) {
		notificationsDataService.createSMSNotification(notifications);
	}

	// Obtener notificaciones por tipo de notificacion
	@GetMapping
	public List<NotificationUser> getNotificationsByType(@RequestParam(name = "searchnotification") String type) {
		return null;
	}

	// Obtener notificaciones por el id de la notificacion
	@GetMapping(Routes.NOTIFICATION_BY_ID)
	public List<NotificationUser> getNotificationsByIdNotifications(
			@PathVariable("idNotifications") Long idNotifications) {
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
	public List<NotificationsData> getNotificationDataByIdNotification(
			@PathVariable("idNotifications") Long idNotifications) {
		return null;
	}

	// Eliminar los datos de envio por medio del id Notifications FK
	@DeleteMapping(Routes.ADD_INFO_TO_NOTIFY)
	public void removeUserDataByIdNotifications(@PathVariable("idNotifications") Long id_notifications) {

	}

}
