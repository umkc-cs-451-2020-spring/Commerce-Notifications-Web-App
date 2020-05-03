package com.group2.commerceserver.models;

public class Filters {
	private int userId;
	private int triggerId;
	private boolean hasNotifications;
	private String startDate;
	private String endDate;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTriggerId() {
		return triggerId;
	}
	public void setTriggerId(int triggerId) {
		this.triggerId = triggerId;
	}
	public boolean isHasNotifications() {
		return hasNotifications;
	}
	public void setHasNotifications(boolean hasNotifications) {
		this.hasNotifications = hasNotifications;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
}
