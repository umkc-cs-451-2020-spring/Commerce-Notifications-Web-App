package com.group2.commerceserver.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountNumber;
	
	@Column(name="UserID")
	private int userId;
	
	@Column(name="AccountType")
	private int accountType;
	
	@Column(name="Balance")
	private double balance;

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @return the accountType
	 */
	public int getAccountType() {
		return accountType;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}
