package com.group2.commerceserver.models;

public class Transaction {
	
	private Integer transactionId;
	
	private Integer accountNumber;
	
	private String description;
	
	private float balance;

	private Float amount;
	  
	private String state;
	  
	private String processingDate;
	  
	private int transactionType;

	private int category;

	
	//Empty constructor
	public Transaction() {
		
	}

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
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
	public Float getBalance() {
		return balance;
	}

	/**
	 * @return the amount
	 */
	public Float getAmount() {
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
	public int getCategory() {
		return category;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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
	 * @param balance the balance to set
	 */
	public void setBalance(Float balance) {
		this.balance = balance;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
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
	public void setCategory(int category) {
		this.category = category;
	}
}