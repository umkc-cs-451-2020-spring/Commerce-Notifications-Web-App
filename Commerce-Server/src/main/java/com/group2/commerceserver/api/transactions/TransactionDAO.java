package com.group2.commerceserver.api.transactions;

import java.util.List;

import com.group2.commerceserver.models.Transaction;

public interface TransactionDAO {
	
	public void saveOrUpdate(Transaction transaction);
	
    public void delete(int transactionId);
    
    public List<Transaction> getUserTransactions(int userId);
     
    public List<Transaction> list();
}