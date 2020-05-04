package com.group2.CommerceServer.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.group2.commerceserver.models.Filters;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.sql.NotificationSql;

public class NotificationSqlTest {
	
	@Test
	public void TestBuildTriggerString() {
		Rule rule = new Rule();
		rule.setUserId(1);
		rule.setTriggerName("TestTrigger");
		rule.setAmount((float) 100.01);
		rule.setBalance((float) 500.01);
		rule.setLocation("MO");
		rule.setStartTime("2020-04-19 12:00:00");
		rule.setEndTime("2020-04-19 12:01:00");
		rule.setCategory("Food");
		
		String expectedResult = NotificationSql.buildTriggerString(rule);
		assertEquals(expectedResult, "CREATE TRIGGER CommerceDB.TestTrigger AFTER INSERT ON CommerceDB.Transaction FOR EACH ROW BEGIN IF NEW.Amount > :amount AND NEW.Balance < :balance AND NEW.State != :location AND TIME(NEW.ProcessingDate) BETWEEN :startTime AND :endTime AND NEW.Category = :category AND NEW.AccountNumber IN (SELECT AccountNumber FROM CommerceDB.Account WHERE UserID = :userId ) THEN INSERT INTO CommerceDB.Notifications(TriggerID, TransactionID, Message, ReadStatus) VALUES((SELECT TriggerID FROM CommerceDB.Trigger WHERE TriggerName = :triggerName), NEW.TransactionID, CONCAT('Transaction at ', NEW.Description, ' is over $', :amount , ' and', ' made balance in account #', NEW.AccountNumber, ' under $', :balance , ' and', ' occurred outside of ', :location , ' and', ' occurred between ', :startTime , ' and ', :endTime , ' and' ' is a ', :category , ' transaction', '.'), false); UPDATE CommerceDB.Trigger SET TriggerCount = TriggerCount + 1 WHERE TriggerName = :triggerName; END IF; END");
	}
	
	@Test
	public void TestBuildFiltersString() {
		Filters filter = new Filters();
		filter.setUserId(1);
		filter.setStartDate("2020-04-19 12:00:00");
		filter.setEndDate("2020-04-19 12:00:00");
		filter.setHasNotifications(true);
		
		String expectedResult = NotificationSql.buildFiltersString(filter);
		assertEquals(expectedResult,"SELECT tab.TriggerID, tab.TriggerName, tab.TriggerCount FROM ( SELECT a.TriggerID, a.TriggerName, (SELECT COUNT(t.TransactionID) FROM CommerceDB.Notifications as n JOIN CommerceDB.Transaction as t ON n.TransactionID = t.TransactionID WHERE n.TriggerID = a.TriggerID AND t.ProcessingDate BETWEEN :startDate AND :endDate ) AS TriggerCount FROM CommerceDB.Trigger AS a WHERE a.UserID = :userId ) tab WHERE tab.TriggerCount > 0;");
	}

}
