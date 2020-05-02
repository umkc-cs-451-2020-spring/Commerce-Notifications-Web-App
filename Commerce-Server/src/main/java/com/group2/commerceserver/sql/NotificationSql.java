package com.group2.commerceserver.sql;

public class NotificationSql {
	public static final String INSERT_TRIGGER = 
			"INSERT IGNORE INTO CommerceDB.Trigger(UserID, TriggerName) " + 
			"VALUES (:userId, :triggerName)";
	
	public static final String DELETE_TRIGGER = 
			"DELETE FROM CommerceDB.Trigger WHERE TriggerID = ?;";
	
	public static final String DELETE_NOTIFICATIONS =
			"DELETE FROM CommerceDB.Notifications WHERE TriggerID = ?;";
	
	public static final String GET_USER_TRIGGERS =
			"SELECT TriggerID, TriggerName, TriggerCount " +
			"FROM CommerceDB.Trigger " +
			"WHERE UserID = ?;";
	
	public static final String GET_NOTIFICATIONS =
			"SELECT n.NotificationID, n.Message, n.ReadStatus, t.AccountNumber, t.ProcessingDate, t.Description, t.Amount, t.Balance, t.State, t.Category " +
			"FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID " +
			"WHERE n.TriggerID = ?";
	
	public static final String GET_USER_NOTIFICATIONS =
			"SELECT n.NotificationID, n.Message, n.ReadStatus, t.AccountNumber, t.ProcessingDate, t.Description, t.Amount, t.Balance, t.State, t.Category " +
			"FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID " +
			"WHERE n.TriggerID  IN (SELECT TriggerID FROM CommerceDB.Trigger WHERE UserID = ?) " +
			"ORDER BY ProcessingDate;";
}
