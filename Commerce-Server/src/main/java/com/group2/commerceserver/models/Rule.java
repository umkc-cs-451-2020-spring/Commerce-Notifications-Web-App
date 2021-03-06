package com.group2.commerceserver.models;

public class Rule {
	
	private int triggerId;
	private int userId;
	private String triggerName;
	private String oldTriggerName;
	private Float amount;
	private Float balance;
	private String location;
	private String startTime;
	private String endTime;
	private String category;
	
	public Rule() {
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public String getSqlTriggerName() {
		return triggerName.replaceAll("[^A-Za-z0-9]", "");
	}
	public void setOldTriggerName(String oldTriggerName) {
		this.oldTriggerName = oldTriggerName;
	}
	public String getOldTriggerName() {
		return oldTriggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public int getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(int triggerId) {
		this.triggerId = triggerId;
	}
	
}
