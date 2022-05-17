package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;

public class UserNotificationsData implements Serializable {

	private Long idUserNotifications;

	private String mail;

	private String phoneNumber;

	private Long idNotifications;

	// Constructor empty
	public UserNotificationsData() {
	}

	// constructor with attributes

	public UserNotificationsData(String mail, String phoneNumber, Long idNotifications) {
		super();
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.idNotifications = idNotifications;
	}

	// Getters and Setters
	public Long getIdUserNotifications() {
		return idUserNotifications;
	}

	public void setIdUserNotifications(Long idUserNotifications) {
		this.idUserNotifications = idUserNotifications;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getIdNotifications() {
		return idNotifications;
	}

	public void setIdNotifications(Long idNotifications) {
		this.idNotifications = idNotifications;
	}

}
