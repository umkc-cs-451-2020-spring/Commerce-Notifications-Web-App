package com.group2.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TransactionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void saveOrUpdate(Transaction transaction) {
		if (transaction.getTransactionId() > 0) {
	        // update
	        String sql = "UPDATE Transaction SET AccountNumber=?, Description=?, Amount=?, State=?, "
	        		+ "Date=?, TransactionType=?, Category=?, RedStatus=? WHERE TransactionID=?";
	        jdbcTemplate.update(sql, transaction.getAccountNumber(), transaction.getDescription(), transaction.getAmount(),
	        		transaction.getState(), transaction.getDate(), transaction.getTransactionType(), transaction.getTransactionId(),
	        		transaction.getCategory(), transaction.getRedStatus());
	        
	        ;
	    } else {
	        // Insert Statement
	        String sql = "INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType, Category, RedStatus )"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, transaction.getAccountNumber(), transaction.getDescription(), transaction.getAmount(),
	        		transaction.getState(), transaction.getDate(), transaction.getTransactionType(), transaction.getCategory(), transaction.getRedStatus());
	    }
	
	}

	@Override
	public void delete(int transactionId) {
		String sql = "DELETE FROM Transaction WHERE TransactionID=?";
		jdbcTemplate.update(sql, transactionId);
		
	}

	@Override
	public Transaction get(int transactionId) {
	    String sql = "SELECT * FROM Transaction WHERE TransactionID=" + transactionId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Transaction>() {
	 
	        @Override
	        public Transaction extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Transaction transaction = new Transaction();
	      
		        	transaction.setTransactionId(rs.getInt("TransactionID"));
		        	transaction.setAccountNumber(rs.getInt("AccountNumber"));
		        	transaction.setDescription(rs.getString("Description"));
		        	transaction.setAmount(rs.getFloat("Amount"));
		        	transaction.setState(rs.getString("State"));
		        	transaction.setDate(rs.getString("Date"));
		        	transaction.setTransactionType(rs.getString("TransactionType"));
		        	transaction.setCategory(rs.getInt("Catergory"));
		        	transaction.setRedStatus(rs.getBoolean("RedStatus"));
		 
		            return transaction;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Transaction> list() {
		String sql = "SELECT * FROM Transaction";
	    List<Transaction> listTransaction = jdbcTemplate.query(sql, new RowMapper<Transaction>() {
	 
	        @Override
	        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Transaction transaction = new Transaction();
	 
	        	transaction.setTransactionId(rs.getInt("TransactionID"));
	        	transaction.setAccountNumber(rs.getInt("AccountNumber"));
	        	transaction.setDescription(rs.getString("Description"));
	        	transaction.setAmount(rs.getFloat("Amount"));
	        	transaction.setState(rs.getString("State"));
	        	transaction.setDate(rs.getString("Date"));
	        	transaction.setTransactionType(rs.getString("TransactionType"));
	        	transaction.setCategory(rs.getInt("Catergory"));
	        	transaction.setRedStatus(rs.getBoolean("RedStatus"));
	        	
	            return transaction;
	        }
	 
	    });
	 
	    return listTransaction;
	}

}
