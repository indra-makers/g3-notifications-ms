package com.co.indra.coinmarketcap.notifications.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserNotificationsRepository {

    @Autowired
    private JdbcTemplate template;

}
