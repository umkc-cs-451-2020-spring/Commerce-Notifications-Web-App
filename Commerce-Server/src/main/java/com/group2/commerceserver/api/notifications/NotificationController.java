package com.group2.commerceserver.api.notifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.commerceserver.models.Notification;
import com.group2.commerceserver.models.Rule;
import com.group2.commerceserver.models.Trigger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	@Autowired
	NotificationDAO notificationDAO;
	
	@PostMapping("/add")
	public void addNotification(@RequestBody Rule rule) {
		notificationDAO.addTrigger(rule);
	}
	
	@GetMapping("/get/{id}/triggers")
	public List<Trigger> getTriggersByUser(@PathVariable(value = "id") int userId) {
		return notificationDAO.getTriggers(userId);
		
	}
	
	@GetMapping("/get/{id}/transactions")
	public List<Notification> getNotificationsByTriggerId(@PathVariable(value = "id") int triggerId) {
		return notificationDAO.getNotifications(triggerId);
		
	}
}
