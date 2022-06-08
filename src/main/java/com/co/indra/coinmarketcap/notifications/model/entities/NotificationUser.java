package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;

public class NotificationUser implements Serializable {

	private Long idNotifications;

	private Long id_user;

	private String mail;

	private String phoneNumber;

	public NotificationUser() {
	}

	public NotificationUser(Long idNotifications, Long id_user, String mail, String phoneNumber) {
		super();
		this.idNotifications = idNotifications;
		this.id_user = id_user;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	}
	public NotificationUser(Long id_user, String mail, String phoneNumber) {
		super();
		this.id_user = id_user;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	}

	public Long getIdNotifications() {
		return idNotifications;
	}

	public void setIdNotifications(Long idNotifications) {
		this.idNotifications = idNotifications;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
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

	// Constructor with attributes

}