package com.group2.commerceserver.api.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group2.commerceserver.models.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AccountDAOImpl() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account get(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> listAccountByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> listAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


}
