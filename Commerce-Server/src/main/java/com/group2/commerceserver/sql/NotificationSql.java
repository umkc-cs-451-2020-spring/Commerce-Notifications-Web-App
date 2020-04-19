package com.group2.commerceserver.sql;

public class NotificationSql {
	public static final String INSERT_TRIGGER = 
			"INSERT IGNORE INTO CommerceDB.Trigger(UserID, TriggerName) " + 
			"VALUES (:userId, :triggerName)";
	
	public static final String GET_USER_TRIGGERS =
			"SELECT TriggerID, TriggerName, TriggerCount " +
			"FROM CommerceDB.Trigger " +
			"WHERE UserID = ?;";
}
