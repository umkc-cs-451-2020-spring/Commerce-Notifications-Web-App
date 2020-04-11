package com.group2.commerceserver.api.notifications;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Notification;

@Repository
public class NotificationDAOImpl implements NotificationDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public NotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	

	@Override
	public void addNotification() {
        String sql = "sql statement here";
        jdbcTemplate.update(sql, "params here");

	}

	@Override
	public void editNotification(int notificationId) {
		String sql = "sql statement here";
        jdbcTemplate.update(sql, "params here");		
	}

	@Override
	public void markAsRead(int notificationId) {
		String sql = "//sql statement here";
        jdbcTemplate.update(sql, "params here");		
	}

	@Override
	public Notification get(int notificationId) {
		String sql = "SELECT * FROM Notifications WHERE TransactionID=" + notificationId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Notification>() {
	 
	        @Override
	        public Notification extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Notification notification = new Notification();
	      
	            	notification.setNotificationId(rs.getInt("NotificationID"));
	            	//rest of the methods to build notification
	            	
		            return notification;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public void delete(int notificationId) {
		String sql = "DELETE FROM Notifications WHERE NotificationID=?";
		jdbcTemplate.update(sql, notificationId);
		
	}

	@Override
	public List<Notification> list() {
		String sql = "SELECT * FROM Notifications";
	    List<Notification> listNotification = jdbcTemplate.query(sql, new RowMapper<Notification>() {
	 
	        @Override
	        public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Notification notification = new Notification();
	 
            	notification.setNotificationId(rs.getInt("NotificationID"));
            	//rest of the methods to build notification
            	
	            return notification;

	        }
	 
	    });
	 
	    return listNotification;
	}

}
