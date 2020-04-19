package com.group2.commerceserver.sql;

public class TransactionSql {

	public static final String GET_USER_TRANSACTIONS = 
			"SELECT AccountNumber, ProcessingDate, Balance, Amount, Description, TransactionType " + 
			"FROM Transaction " + 
			"WHERE AccountNumber IN (SELECT AccountNumber FROM Account Where UserID = ?) " +
			"ORDER BY ProcessingDate DESC;";
	
	public static final String INSERT_TRANSACTION =
			"INSERT INTO Transaction (AccountNumber, Description, Amount, State, ProcessingDate, TransactionType, Category )"
			+ "VALUES (:accountNumber, :description, :amount, :state, :processingDate, :transactionType, :category)";
	
}
