package com.co.indra.coinmarketcap.notifications.model.entities;



import java.io.Serializable;

public class Notifications implements Serializable {


    private Long userId;


    private String mailUser;


    private String phoneNumber;


    //constructor empty
    public Notifications() {
    }

    //constructor with attributes
    public Notifications(Long userId, String mailUser, String phoneNumber) {
        this.userId = userId;
        this.mailUser = mailUser;
        this.phoneNumber = phoneNumber;
    }


    //Getters ans Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
