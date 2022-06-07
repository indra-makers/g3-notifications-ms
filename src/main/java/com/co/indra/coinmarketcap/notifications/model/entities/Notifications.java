package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Notifications implements Serializable {

	private Long idNotifications;

	private String type;

	private String message;

	private Date sentAt;

	private Long idUser;
	private String subject;

	public Notifications(Long idNotifications, String type, String message, Date sentAt, Long idUser, String subject, String sendTo) {
		this.idNotifications = idNotifications;
		this.type = type;
		this.message = message;
		this.sentAt = sentAt;
		this.idUser = idUser;
		this.subject = subject;
	}

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Notifications() {
	}

}