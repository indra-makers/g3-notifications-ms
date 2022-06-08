package com.co.indra.coinmarketcap.notifications.repositories;

import com.co.indra.coinmarketcap.notifications.model.entities.NotificationUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class NotificationsRowMapper implements RowMapper<NotificationUser> {

	public NotificationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotificationUser notifications = new NotificationUser();
		notifications.setId_user(rs.getLong("id_user"));
		notifications.setMail(rs.getString("mail"));
		notifications.setPhoneNumber(rs.getString("phone_number"));
		return notifications;
	}
}

@Repository
public class NotificationsRepository {

	@Autowired
	private JdbcTemplate template;

	public void createNotificationUserData(NotificationUser notification) {
		template.update("INSERT INTO tbl_notifications_user(id_user, mail, phone_number) values(?,?,?)",
				notification.getId_user(), notification.getMail(), notification.getPhoneNumber());
	}

	public List<NotificationUser> findPhoneByIdUser(Long idUser) {
		return template.query("select id_user, mail, phone_number from tbl_notifications_user where id_user=?",
				new NotificationsRowMapper(),idUser);
	}

}
