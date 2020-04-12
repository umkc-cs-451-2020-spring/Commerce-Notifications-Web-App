package com.group2.commerceserver.models;

public class Rule {

	private int userId;
	private String triggerName;
	private int triggerType;
	private String triggerDescription;
	private Float amount;
	
	public Rule() {
//		triggerName = "amount_over_" + amount + "_user" + userId;
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
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public int getTriggerType() {
		return triggerType;
	}
	public void setTriggerType(int triggerType) {
		this.triggerType = triggerType;
	}
	public String getTriggerDescription() {
		return triggerDescription;
	}
	public void setTriggerDescription(String triggerDescription) {
		this.triggerDescription = triggerDescription;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
}
