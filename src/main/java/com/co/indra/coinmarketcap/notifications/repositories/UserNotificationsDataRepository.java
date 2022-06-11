package com.co.indra.coinmarketcap.notifications.repositories;

import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class UserNotificationsDataRowMapper implements RowMapper<UserNotificationsData> {

   @Override
   public UserNotificationsData mapRow(ResultSet rs, int rowNum) throws SQLException {
      UserNotificationsData userNotificationsData = new UserNotificationsData();
      userNotificationsData.setIdUser(rs.getLong("id_user"));
      userNotificationsData.setMail(rs.getString("mail"));
      userNotificationsData.setPhoneNumber(rs.getString("phone_number"));
      return userNotificationsData;
   }
}

@Repository
public class UserNotificationsDataRepository {

   @Autowired
   private JdbcTemplate template;

   public void createUserNotificationData(UserNotificationsData userData) {
      template.update("INSERT INTO tbl_user_notifications_data(id_user,mail,phone_number) values(?,?,?)",
            userData.getIdUser(), userData.getMail(), userData.getPhoneNumber());
   }

}