package com.group2.commerceserver.models;

public class Trigger {
	private int triggerID;
	private int userID;
	private String triggerName;
	private int triggerCount;
	
	public int getTriggerID() {
		return triggerID;
	}
	public void setTriggerID(int triggerID) {
		this.triggerID = triggerID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public int getTriggerCount() {
		return triggerCount;
	}
	public void setTriggerCount(int triggerCount) {
		this.triggerCount = triggerCount;
	}
}
