package com.group2.commerceserver.api.notifications;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.group2.commerceserver.models.Filters;
import com.group2.commerceserver.models.Notification;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.models.Trigger;
import com.group2.commerceserver.rowmappers.NotificationRowMapper;
import com.group2.commerceserver.rowmappers.TriggerRowMapper;
import com.group2.commerceserver.sql.NotificationSql;

@Service
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
			jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + rule.getSqlTriggerName() + ";");
			namedParameterJdbcTemplate.update(NotificationSql.INSERT_TRIGGER, paramSource);
			namedParameterJdbcTemplate.update(NotificationSql.buildTriggerString(rule), paramSource);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteTrigger(int triggerId, String triggerName) {
		try {
		jdbcTemplate.update(NotificationSql.DELETE_NOTIFICATIONS, new Object[] { triggerId });
		jdbcTemplate.update(NotificationSql.DELETE_TRIGGER, new Object[] { triggerId });
		jdbcTemplate.execute("DROP TRIGGER IF EXISTS CommerceDB." + triggerName.replaceAll("[^A-Za-z0-9]", "") + ";");

		}catch( Exception e ) {
			return false;
		}
		return true;
	}

	@Override
	public List<Trigger> getTriggers(Filters filters) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("userId", filters.getUserId())
				.addValue("startDate", filters.getStartDate())
				.addValue("endDate", filters.getEndDate());
		return namedParameterJdbcTemplate.query(NotificationSql.buildFiltersString(filters), paramSource, new TriggerRowMapper());
	}

	@Override
	public List<Notification> getNotifications(Filters filters) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("triggerId", filters.getTriggerId())
				.addValue("startDate", filters.getStartDate())
				.addValue("endDate", filters.getEndDate());
	    String sql = NotificationSql.GET_NOTIFICATIONS + NotificationSql.buildDateString(filters) + ';';
		return namedParameterJdbcTemplate.query(sql, paramSource, new NotificationRowMapper());
	}
	
	@Override
	public List<Notification> getAllNotifications(Filters filters) {
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("userId", filters.getUserId())
				.addValue("startDate", filters.getStartDate())
				.addValue("endDate", filters.getEndDate());
	    String sql = NotificationSql.GET_USER_NOTIFICATIONS + NotificationSql.buildDateString(filters) + " ORDER BY ProcessingDate;";
	    return namedParameterJdbcTemplate.query(sql, paramSource, new NotificationRowMapper());
	}

}
