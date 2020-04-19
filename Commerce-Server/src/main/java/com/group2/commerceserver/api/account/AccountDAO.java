package com.group2.commerceserver.api.account;

import java.util.List;

import com.group2.commerceserver.models.Account;

public interface AccountDAO {
	
	public void addAccount();
	
	public void editAccount(int accountNumber);
	
	public Account get(int accountNumber);
	
	public void delete(int accountNumber);
	
	public List<Account> listAccountByUser(int userId);
	
	public List<Account> listAllAccounts();

}
