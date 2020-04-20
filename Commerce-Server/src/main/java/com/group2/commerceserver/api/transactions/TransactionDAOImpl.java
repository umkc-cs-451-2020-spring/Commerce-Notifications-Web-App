package com.group2.commerceserver.api.transactions;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Transaction;
import com.group2.commerceserver.rowmappers.TransactionRowMapper;
import com.group2.commerceserver.sql.TransactionSql;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public TransactionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void addTransaction(Transaction transaction) {

		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("accountNumber", transaction.getAccountNumber())
				.addValue("description", transaction.getDescription())
				.addValue("amount", transaction.getAmount())
				.addValue("state", transaction.getState())
				.addValue("processingDate", transaction.getProcessingDate())
				.addValue("transactionType", transaction.getTransactionType())
				.addValue("category", transaction.getCategory());
		namedParameterJdbcTemplate.update(TransactionSql.INSERT_TRANSACTION, paramSource);
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