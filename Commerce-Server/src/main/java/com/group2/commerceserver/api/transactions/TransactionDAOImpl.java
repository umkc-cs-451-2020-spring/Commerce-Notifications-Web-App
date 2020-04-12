package com.group2.commerceserver.api.transactions;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Transaction;
import com.group2.commerceserver.rowmappers.TransactionRowMapper;
import com.group2.commerceserver.sql.TransactionSql;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public TransactionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void saveOrUpdate(Transaction transaction) {
		if (transaction.getTransactionId() > 0) {
	        // update
	        String sql = "UPDATE Transaction SET AccountNumber=?, Description=?, Amount=?, State=?, "
	        		+ "ProcessingDate=?, TransactionType=?, Category=?, RedStatus=? WHERE TransactionID=?";
	        jdbcTemplate.update(sql, transaction.getAccountNumber(), transaction.getDescription(), transaction.getAmount(),
	        		transaction.getState(), transaction.getProcessingDate(), transaction.getTransactionType(), transaction.getTransactionId(),
	        		transaction.getCategory());
	    } else {
	        // Insert Statement
	        String sql = "INSERT INTO Transaction( AccountNumber, Description, Amount, State, ProcessingDate, TransactionType, Category )"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, transaction.getAccountNumber(), transaction.getDescription(), transaction.getAmount(),
	        		transaction.getState(), transaction.getProcessingDate(), transaction.getTransactionType(), transaction.getCategory());
	    }
	
	}

	@Override
	public void delete(int transactionId) {
		String sql = "DELETE FROM Transaction WHERE TransactionID=?";
		jdbcTemplate.update(sql, transactionId);
		
	}

	@Override
	public List<Transaction> getUserTransactions(int userId) {
	    String sql = TransactionSql.GET_USER_TRANSACTIONS;
	    return jdbcTemplate.query(sql, new Object[] { userId }, new TransactionRowMapper());
	}

	@Override
	public List<Transaction> list() {
		String sql = "SELECT * FROM Transaction";
	    List<Transaction> listTransaction = jdbcTemplate.query(sql, new TransactionRowMapper());
	 
	    return listTransaction;
	}

}