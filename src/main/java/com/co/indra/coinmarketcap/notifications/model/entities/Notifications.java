package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Notifications implements Serializable {

	private Long idNotifications;

	private String type;

	private String message;

	private Date sentAt;

	private Long idUser;



	public Notifications() {
	}

	// Constructor with attributes

	public Notifications(String type, String message, Long idUser, String sentTo) {
		super();
		this.type = type;
		this.message = message;
		this.idUser = idUser;

	}

	// Getters and Setters
	public Long getIdNotifications() {
		return idNotifications;
	}

	public void setIdNotifications(Long idNotifications) {
		this.idNotifications = idNotifications;
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

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



}