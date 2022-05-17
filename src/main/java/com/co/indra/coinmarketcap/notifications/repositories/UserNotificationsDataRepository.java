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
		userNotificationsData.setId_user_notifications(rs.getLong("id_user_notifications"));
		userNotificationsData.setMail(rs.getString("mail"));
		userNotificationsData.setPhone_number(rs.getString("phone_number"));
		userNotificationsData.setId_notifications(rs.getLong("id_notifications"));
		return userNotificationsData;
	}
}

@Repository
public class UserNotificationsDataRepository {

	@Autowired
	private JdbcTemplate template;

}