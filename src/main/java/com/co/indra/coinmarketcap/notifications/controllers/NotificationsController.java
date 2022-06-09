package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.model.requests.NotificationsDataRequest;
import com.co.indra.coinmarketcap.notifications.services.NotificationsService;
import com.co.indra.coinmarketcap.notifications.services.UserNotificationsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import com.co.indra.coinmarketcap.notifications.config.Routes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATIONS_PATH)
public class NotificationsController {

	@Autowired
	private NotificationsService notificationsService;

	@Autowired
	private UserNotificationsDataService userNotificationsDataService;

	/******** Comienzo de controladores para entidad Notifications */

	// Crear nueva notificacion
	public void createUserData(@RequestBody UserNotificationsData userNotificationsData) {
      userNotificationsDataService.createNotificationUserData(userNotificationsData);
   }
	
	//Enviar un mensaje de texto
	@PostMapping(Routes.SEND_SMS_PATH)
   public void CreateSMS(@RequestBody Notifications notifications){
	   notificationsService.createSMSNotification(notifications);
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
	@DeleteMapping("/{idNotifications}/usernotificationsdata")
	public void removeUserDataByIdNotifications(@PathVariable("idNotifications") Long id_notifications) {

	}

}
