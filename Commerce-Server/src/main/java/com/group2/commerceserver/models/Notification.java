package com.group2.commerceserver.models;

public class Notification {

	private Integer notificationId;

    private Integer accountNumber;
    
    private String processingDate;
    
    private String message;

    private String description;

    private String state; 

    private Double amount;
    
    private Double balance;

    private int transactionType;
    
    private String category; 

    private boolean readStatus;
	
	//Empty constructor
	public Notification() {
		
	}

	/**
	 * @return the notificationId
	 */
	public Integer getNotificationId() {
		return notificationId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the readStatus
	 */
	public boolean isReadStatus() {
		return readStatus;
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
	 * @return the processingDate
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
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
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
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @param processingDate the processingDate to set
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
	 * @param category the category to get
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @param state the state to get
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
}
