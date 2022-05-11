package com.co.indra.coinmarketcap.notifications.model.entities;


import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_notifications")
public class UserNotificationsData {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private Long userId;

@Column(name = "type")
private String typeNotification;

@Column(name = "message")
private String messageNotification;

@Column (name = "sent_at")
private Date sentAt;



    //Constructor empty
    public UserNotificationsData() {
    }

    //Constructor with attributes
    public UserNotificationsData(Long userId, String typeNotification, String messageNotification, Date sentAt) {
        this.userId = userId;
        this.typeNotification = typeNotification;
        this.messageNotification = messageNotification;
        this.sentAt = sentAt;
    }


    //Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    public String getMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(String messageNotification) {
        this.messageNotification = messageNotification;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
}
