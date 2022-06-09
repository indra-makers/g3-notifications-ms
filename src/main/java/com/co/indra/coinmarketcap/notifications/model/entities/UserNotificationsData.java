package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;

public class UserNotificationsData implements Serializable {

	private Long idUser;

	private String mail;

	private String phoneNumber;

	

	// Constructor empty
	public UserNotificationsData() {
	}

	// constructor with attributes

	public UserNotificationsData(Long idUser, String mail, String phoneNumber) {
	   this.idUser = idUser;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	
	}

	// Getters and Setters
	public Long getIdUser() {
      return idUser;
	}

	public void setIdUser(Long idUser) {
      this.idUser = idUser;
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



}
