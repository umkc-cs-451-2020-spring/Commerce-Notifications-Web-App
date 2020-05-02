package com.group2.commerceserver.api.transactions;

import java.util.List;

import com.group2.commerceserver.models.Transaction;

public interface TransactionDAO {
	
	public int addTransaction(Transaction transaction);
    
    public List<Transaction> getUserTransactions(int userId);
}