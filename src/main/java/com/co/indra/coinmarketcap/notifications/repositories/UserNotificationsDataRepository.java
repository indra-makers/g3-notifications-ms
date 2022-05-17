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
		userNotificationsData.setIdUserNotifications(rs.getLong("idUserNotifications"));
		userNotificationsData.setMail(rs.getString("mail"));
		userNotificationsData.setPhoneNumber(rs.getString("phoneNumber"));
		userNotificationsData.setIdNotifications(rs.getLong("idNotifications"));
		return userNotificationsData;
	}
}

@Repository
public class UserNotificationsDataRepository {

	@Autowired
	private JdbcTemplate template;

}