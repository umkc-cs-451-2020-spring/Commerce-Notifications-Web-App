package com.group2.commerceserver.sql;

public class NotificationSql {
	public static final String INSERT_TRIGGER = 
			"REPLACE INTO CommerceDB.Trigger(UserID, TriggerName, TriggerType, TriggerDescription) " + 
			"VALUES (:userId, :triggerName, :triggerType, :triggerDescription);";
	public static final String ADD_AMOUNT_TRIGGER =
			"DELIMITER $$ " + 
			"USE `CommerceDB`$$ " +
			"CREATE DEFINER=`commerce-notifications`@`%` TRIGGER `CommerceDB`.`:triggerName` " +
			"AFTER INSERT ON `Transaction` FOR EACH ROW " + 
			"BEGIN " + 
			"	IF NEW.Amount > :amount AND NEW.AccountNumber IN " + 
			"		( SELECT AccountNumber FROM Account WHERE UserID = :userId ) " + 
			"	THEN " + 
			"		INSERT INTO Notifications(TriggerID, TransactionID, Message, ReadStatus) " + 
			"        VALUES((SELECT TriggerID FROM CommerceDB.Trigger WHERE TriggerName=:triggerName), " +
			"				 NEW.TransactionID, :triggerName, false); " + 
			"	END IF; " + 
			"END$$ " + 
			"DELIMITER ;";
}
