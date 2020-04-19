package com.group2.commerceserver.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group2.commerceserver.models.Notification;

public class NotificationRowMapper implements RowMapper<Notification> {
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notification notification = new Notification();
		notification.setNotificationId( rs.getInt("NotificationID") );
		notification.setMessage( rs.getString("Message") );
		notification.setReadStatus( rs.getBoolean("ReadStatus") );
		notification.setAccountNumber( rs.getInt("AccountNumber") );
		notification.setProcessingDate( rs.getString("ProcessingDate") );
		notification.setDescription( rs.getString("Description") );
		notification.setAmount( rs.getFloat("Amount") );
		notification.setBalance( rs.getFloat("Balance") );
		return notification;
	}
}
