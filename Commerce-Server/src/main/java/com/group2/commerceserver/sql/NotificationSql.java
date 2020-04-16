package com.group2.commerceserver.sql;

public class NotificationSql {
	public static final String INSERT_TRIGGER = 
			"INSERT IGNORE INTO CommerceDB.Trigger(UserID, TriggerName) " + 
			"VALUES (:userId, :triggerName)";
}
