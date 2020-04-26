package com.group2.commerceserver.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group2.commerceserver.models.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Transaction transaction = new Transaction();
    	transaction.setAccountNumber(rs.getInt("AccountNumber"));
    	transaction.setProcessingDate(rs.getString("ProcessingDate"));
    	transaction.setBalance(rs.getDouble("Balance"));
    	transaction.setAmount(rs.getDouble("Amount"));
    	transaction.setDescription(rs.getString("Description"));
    	transaction.setState(rs.getString("State"));
    	transaction.setTransactionType(rs.getInt("TransactionType"));
    	transaction.setCategory(rs.getString("Category"));

        return transaction;
    }
}
