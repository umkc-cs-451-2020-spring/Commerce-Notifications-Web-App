package com.group2.commerceserver.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group2.commerceserver.models.Trigger;

public class TriggerRowMapper implements RowMapper<Trigger> {
	public Trigger mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trigger trigger = new Trigger();
		trigger.setTriggerID(rs.getInt("TriggerID"));
		trigger.setTriggerName(rs.getString("TriggerName"));
		trigger.setTriggerCount(rs.getInt("TriggerCount"));
		return trigger;
	}
}
