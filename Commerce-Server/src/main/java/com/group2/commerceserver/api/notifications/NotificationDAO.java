package com.group2.commerceserver.api.notifications;

import java.util.List;

import com.group2.commerceserver.models.Filters;
import com.group2.commerceserver.models.Notification;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.models.Trigger;

public interface NotificationDAO {
	
	public boolean addTrigger(Rule rule);
	
	public boolean deleteTrigger(int triggerId, String triggerName);
	
	boolean changeReadStatus(int notificationId);

	public List<Trigger> getTriggers(Filters filters);
	
	public List<Notification> getNotifications(Filters filters);
	
	public List<Notification> getAllNotifications(Filters filters);
}
