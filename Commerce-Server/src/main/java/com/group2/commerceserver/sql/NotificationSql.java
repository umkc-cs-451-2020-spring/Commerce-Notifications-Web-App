package com.group2.commerceserver.sql;

import com.group2.commerceserver.models.Filters;
import com.group2.commerceserver.models.Rule;

public class NotificationSql {
	public static final String INSERT_TRIGGER = 
			"INSERT IGNORE INTO CommerceDB.Trigger(UserID, TriggerName) " + 
			"VALUES (:userId, :triggerName)";
	
	public static final String DELETE_TRIGGER = 
			"DELETE FROM CommerceDB.Trigger WHERE TriggerID = ?;";
	
	public static final String DELETE_NOTIFICATIONS =
			"DELETE FROM CommerceDB.Notifications WHERE TriggerID = ?;";
	
	public static final String GET_NOTIFICATIONS =
			"SELECT n.NotificationID, n.Message, n.ReadStatus, t.AccountNumber, t.ProcessingDate, t.Description, t.Amount, t.Balance, t.State, t.Category " +
			"FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID " +
			"WHERE n.TriggerID = :triggerId ";
	
	public static final String GET_USER_NOTIFICATIONS =
			"SELECT n.NotificationID, n.Message, n.ReadStatus, t.AccountNumber, t.ProcessingDate, t.Description, t.Amount, t.Balance, t.State, t.Category " +
			"FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID " +
			"WHERE n.TriggerID IN (SELECT TriggerID FROM CommerceDB.Trigger WHERE UserID = :userId) ";
	
	/* Kory Overbay - Function takes in rule parameters from user input
	 * and builds a sql script to add a trigger that matches the conditions provided
	 */
	public static String buildTriggerString(Rule rule) {
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
	
	public static String buildFiltersString(Filters filters) {
		StringBuilder sql = new StringBuilder();
		if (filters.isHasNotifications()) {
			sql.append("SELECT tab.TriggerID, tab.TriggerName, tab.TriggerCount FROM ( ");
		}
		sql.append("SELECT a.TriggerID, a.TriggerName, " +
						"(SELECT COUNT(t.TransactionID) " +
						 "FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID " +
						 "WHERE n.TriggerID = a.TriggerID");
		if (filters.getStartDate() != null && filters.getStartDate() != "") {
			sql.append(" AND t.ProcessingDate ");
			if (filters.getEndDate() != null && filters.getEndDate() != "") {
				sql.append("BETWEEN :startDate AND :endDate ");
			}
			else {
				sql.append("> :startDate");
			}
		}
		sql.append(") AS TriggerCount " +
				"FROM CommerceDB.Trigger AS a " +
				"WHERE a.UserID = :userId");
		if (filters.isHasNotifications()) {
			sql.append(" ) tab WHERE tab.TriggerCount > 0");
		}
		sql.append(';');
		return sql.toString();
	}

	public static String buildNotificationsString(Filters filters) {
		StringBuilder sql = new StringBuilder();
		if (filters.getStartDate() != null && filters.getStartDate() != "") {
			sql.append(" AND t.ProcessingDate ");
			if (filters.getEndDate() != null && filters.getEndDate() != "") {
				sql.append("BETWEEN :startDate AND :endDate ");
			}
			else {
				sql.append("> :startDate");
			}
		}
		return sql.toString();
	}
}
