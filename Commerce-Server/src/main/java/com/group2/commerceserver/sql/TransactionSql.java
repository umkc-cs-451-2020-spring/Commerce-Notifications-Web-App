package com.group2.commerceserver.sql;

public class TransactionSql {

	public static final String GET_USER_TRANSACTIONS = 
			"SELECT t.AccountNumber, t.ProcessingDate, a.Balance, t.Amount, t.Description\r\n" + 
			"FROM Transaction t JOIN Account a ON t.AccountNumber = a.AccountNumber\r\n" + 
			"WHERE a.UserID = ?;";
}
