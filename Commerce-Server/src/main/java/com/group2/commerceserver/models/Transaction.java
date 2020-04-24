package com.group2.commerceserver.models;

public class Transaction {
	
	private Integer accountNumber;
	
	private String description;
	
	private Double balance;

	private Double amount;
	  
	private String state;
	  
	private String processingDate;
	  
	private int transactionType;

	private String category;

	
	//Empty constructor
	public Transaction() {
		
	}

	/**
	 * @return the accountNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the date
	 */
	public String getProcessingDate() {
		return processingDate;
	}

	/**
	 * @return the transactionType
	 */
	public int getTransactionType() {
		return transactionType;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param d the balance to set
	 */
	public void setBalance(double d) {
		this.balance = d;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param date the date to set
	 */
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}