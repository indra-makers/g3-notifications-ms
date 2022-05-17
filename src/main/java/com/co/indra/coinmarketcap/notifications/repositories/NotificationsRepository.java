package com.co.indra.coinmarketcap.notifications.repositories;

import com.co.indra.coinmarketcap.notifications.model.entities.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class NotificationsRowMapper implements RowMapper<Notifications> {

	@Override
	public Notifications mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notifications notifications = new Notifications();
		notifications.setIdNotifications(rs.getLong("idNotifications"));
		notifications.setType(rs.getString("type"));
		notifications.setMessage(rs.getString("message"));
		notifications.setSentAt(rs.getDate("sentAt"));
		notifications.setIdUser(rs.getLong("idUser"));
		return notifications;
	}
}

@Repository
public class NotificationsRepository {

	@Autowired
	private JdbcTemplate template;

}
