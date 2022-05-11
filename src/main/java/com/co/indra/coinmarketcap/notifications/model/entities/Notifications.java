package com.co.indra.coinmarketcap.notifications.model.entities;


import javax.persistence.*;

@Entity
@Table(name = "tbl_user_notifications_data")

public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "mail")
    private String mailUser;

    @Column(name = "phone_number")
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
