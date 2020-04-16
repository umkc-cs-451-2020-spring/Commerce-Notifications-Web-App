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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Notification;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.sql.NotificationSql;

@Repository
public class NotificationDAOImpl implements NotificationDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void addNotification(Rule rule) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("userId", rule.getUserId())
				.addValue("triggerName", rule.getTriggerName())
				.addValue("amount", rule.getAmount())
				.addValue("location", rule.getLocation())
				.addValue("startTime", rule.getStartTime())
				.addValue("endTime", rule.getEndTime())
				.addValue("category", rule.getCategory());
		jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + rule.getTriggerName() + ";");
		namedParameterJdbcTemplate.update(NotificationSql.INSERT_TRIGGER, paramSource);
		namedParameterJdbcTemplate.update(buildTriggerString(rule), paramSource);
	}

	//TODO Add conditions for building rule types other than Amount
	private String buildTriggerString(Rule rule) {
		StringBuilder sql = new StringBuilder();
		StringBuilder message = new StringBuilder();
		sql.append( "CREATE TRIGGER CommerceDB." + rule.getTriggerName() + " " +
					"AFTER INSERT ON CommerceDB.Transaction FOR EACH ROW " +
					"BEGIN " +
						"IF ");
		message.append("CONCAT('Transaction at ', NEW.Description, ");
		boolean prevRules = false;
		if (rule.getAmount() != null && rule.getAmount() != 0) {
			sql.append("NEW.Amount > :amount");
			message.append("' is over $', :amount , ");
			prevRules = true;
		}
		if (!rule.getLocation().isEmpty() && !rule.getLocation().equals("")) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and', ");
			}
			//TODO If we want multiple states to be allowed we can make for loop to add an array of locations
			sql.append("NEW.State != :location");
			message.append("' occurred outside of ', :location , ");
			prevRules = true;
		}
		if (rule.getStartTime() != null && !rule.getStartTime().toString().equals("")
				&& rule.getEndTime() != null && !rule.getEndTime().toString().equals("")) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and', ");
			}
			sql.append("TIME(NEW.ProcessingDate) BETWEEN :startTime AND :endTime");
			message.append("' occurred between ', :startTime , ' and ', :endTime , ");
			prevRules = true;
		}
		if (rule.getCategory() != null && !rule.getCategory().equals("")) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and' ");
			}
			sql.append("NEW.Category = :category");
			message.append("' is a ', :category , ' transaction', ");
		}
		message.append("'.')");
		//TODO Need to add conditionals for creating message
		sql.append( " AND NEW.AccountNumber IN " +
						"(SELECT AccountNumber FROM CommerceDB.Account WHERE UserID = :userId ) " +
					"THEN INSERT INTO CommerceDB.Notifications(TriggerID, TransactionID, Message, ReadStatus) " +
						"VALUES((SELECT TriggerID FROM CommerceDB.Trigger WHERE TriggerName = :triggerName), " +
								"NEW.TransactionID, " + message + ", false); " +
					"END IF; " +
				"END");
		return sql.toString();
	}

	@Override
	public void editnotification(int notificationId) {
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
