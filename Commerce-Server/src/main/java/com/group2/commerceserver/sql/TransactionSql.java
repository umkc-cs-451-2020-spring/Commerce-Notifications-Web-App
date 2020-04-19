package com.group2.commerceserver.sql;

public class TransactionSql {

	public static final String GET_USER_TRANSACTIONS = 
			"SELECT AccountNumber, ProcessingDate, Balance, Amount, Description, TransactionType " + 
			"FROM Transaction " + 
			"WHERE AccountNumber IN (SELECT AccountNumber FROM Account Where UserID = ?) " +
			"ORDER BY ProcessingDate DESC;";
}
