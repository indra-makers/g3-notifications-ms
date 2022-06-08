package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.util.Date;

public class NotificationsData implements Serializable {

	private Long idUser;

	private Long idNotification;

	private String type;

	private String message;


	public NotificationsData(Long idUser, Long idNotification, String type, String message) {
		super();
		this.idUser = idUser;
		this.idNotification = idNotification;
		this.type = type;
		this.message = message;
	}

	public NotificationsData() {
		super();
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	// Constructor empty

}
