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
				.addValue("triggerType", rule.getTriggerType())
				.addValue("triggerDescription", rule.getTriggerDescription())
				.addValue("amount", rule.getAmount());
		jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + rule.getTriggerName() + ";");
		namedParameterJdbcTemplate.update(NotificationSql.INSERT_TRIGGER, paramSource);
		jdbcTemplate.execute(buildTriggerString(rule));
	}

	//TODO Add conditions for building rule types other than Amount
	private String buildTriggerString(Rule rule) {
		StringBuilder sql = new StringBuilder();
		sql.append( "CREATE TRIGGER CommerceDB." + rule.getTriggerName() + " " +
					"AFTER INSERT ON CommerceDB.Transaction FOR EACH ROW " +
					"BEGIN " +
						"IF ");
		boolean prevRules = false;
		if ((rule.getAmount() != null) && (rule.getAmount() != 0)) {
			sql.append("NEW.Amount > " + rule.getAmount() + " ");
			prevRules = true;
		}
		sql.append( "AND NEW.AccountNumber IN " +
						"(SELECT AccountNumber FROM CommerceDB.Account WHERE UserID = " + rule.getUserId() + " ) " +
					"THEN INSERT INTO CommerceDB.Notifications(TriggerID, TransactionID, Message, ReadStatus) " +
						"VALUES((SELECT TriggerID FROM CommerceDB.Trigger WHERE TriggerName = '" + rule.getTriggerName() + "'), " +
								"NEW.TransactionID, CONCAT('Transaction at ', NEW.Description, ' is over $" + rule.getAmount() + "'), false); " +
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
