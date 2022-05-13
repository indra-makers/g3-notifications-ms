package com.co.indra.coinmarketcap.notifications.repositories;


import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class NotificationsRepository {

    @Autowired
    private JdbcTemplate template;


}
