package com.group2.commerceserver.api.notifications;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Notification;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.models.Trigger;
import com.group2.commerceserver.rowmappers.NotificationRowMapper;
import com.group2.commerceserver.rowmappers.TriggerRowMapper;
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
	public boolean addTrigger(Rule rule) {
		try {
			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("userId", rule.getUserId())
					.addValue("triggerName", rule.getTriggerName())
					.addValue("amount", rule.getAmount())
					.addValue("balance", rule.getBalance())
					.addValue("location", rule.getLocation())
					.addValue("startTime", rule.getStartTime())
					.addValue("endTime", rule.getEndTime())
					.addValue("category", rule.getCategory());
			jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + rule.getTriggerName() + ";");
			namedParameterJdbcTemplate.update(NotificationSql.INSERT_TRIGGER, paramSource);
			namedParameterJdbcTemplate.update(buildTriggerString(rule), paramSource);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	/* Kory Overbay - Function takes in rule parameters from user input
	 * and builds a sql script to add a trigger that matches the conditions provided
	 */
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
		if (rule.getBalance() != null && rule.getBalance() != 0) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and', ");
			}
			sql.append("NEW.Balance < :balance");
			message.append("' made balance in account #', NEW.AccountNumber, ' under $', :balance , ");
			prevRules = true;
		}
		if (rule.getLocation() != null && !rule.getLocation().isEmpty()) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and', ");
			}
			//TODO If we want multiple states to be allowed we can make for loop to add an array of locations
			sql.append("NEW.State != :location");
			message.append("' occurred outside of ', :location , ");
			prevRules = true;
		}
		if (rule.getStartTime() != null && !rule.getStartTime().isEmpty()
				&& rule.getEndTime() != null && !rule.getEndTime().isEmpty()) {
			if (prevRules) {
				sql.append(" AND ");
				message.append("' and', ");
			}
			sql.append("TIME(NEW.ProcessingDate) BETWEEN :startTime AND :endTime");
			message.append("' occurred between ', :startTime , ' and ', :endTime , ");
			prevRules = true;
		}
		if (rule.getCategory() != null && !rule.getCategory().isEmpty()) {
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
						"UPDATE CommerceDB.Trigger SET TriggerCount = TriggerCount + 1 WHERE TriggerName = :triggerName; " +
					"END IF; " +
				"END");
		return sql.toString();
	}
	
	@Override
	public boolean deleteTrigger(int triggerId, String triggerName) {
		try {
		jdbcTemplate.update(NotificationSql.DELETE_NOTIFICATIONS, new Object[] { triggerId });
		jdbcTemplate.update(NotificationSql.DELETE_TRIGGER, new Object[] { triggerId });
		jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + triggerName + ";");
		}catch( Exception e ) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Trigger> getTriggers(int userId) {
	    String sql = NotificationSql.GET_USER_TRIGGERS;
	    return jdbcTemplate.query(sql, new Object[] { userId }, new TriggerRowMapper());
	}

	@Override
	public void markAsRead(int notificationId) {
		String sql = "//sql statement here";
        jdbcTemplate.update(sql, "params here");		
	}

	@Override
	public List<Notification> getNotifications(int triggerId) {
	    String sql = NotificationSql.GET_NOTIFICATIONS;
		return jdbcTemplate.query(sql, new Object[] { triggerId }, new NotificationRowMapper());
	}


}
