package com.group2.commerceserver.sql;

public class TransactionSql {

	public static final String GET_USER_TRANSACTIONS = 
			"SELECT t.AccountNumber, t.ProcessingDate, a.Balance, t.Amount, t.Description, t.TransactionType " + 
			"FROM Transaction t JOIN Account a ON t.AccountNumber = a.AccountNumber " + 
			"WHERE a.UserID = ? " +
			"ORDER BY t.ProcessingDate DESC;";
}
