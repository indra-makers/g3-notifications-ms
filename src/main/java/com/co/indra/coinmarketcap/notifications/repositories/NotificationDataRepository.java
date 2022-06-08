package com.co.indra.coinmarketcap.notifications.repositories;

import com.co.indra.coinmarketcap.notifications.model.entities.NotificationsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

class NotificationsDataRowMapper implements RowMapper<NotificationsData> {

	@Override
	public NotificationsData mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotificationsData notifications = new NotificationsData();
		notifications.setIdUser(rs.getLong("id_user"));
		notifications.setIdNotification(rs.getLong("id_notification"));
		notifications.setType(rs.getString("type"));
		notifications.setMessage(rs.getString("message"));

		return notifications;
	}
}

@Repository
public class NotificationDataRepository {

	@Autowired
	private JdbcTemplate template;

	public void saveNotificationData(NotificationsData notifications) {
		template.update(
				"INSERT INTO tbl_user_notifications_data(id_user,id_notification,type,message) values(?,?,?,?)",
				notifications.getIdUser(), notifications.getIdNotification(), notifications.getType(),
				notifications.getMessage());
	}

}
