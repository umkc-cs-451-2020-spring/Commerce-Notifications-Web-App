package com.group2.commerceserver.api.notifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void addTrigger(@RequestBody Rule rule) {
		notificationDAO.addTrigger(rule);
	}
	
	@PostMapping("/edit")
	public void editTrigger(@RequestBody Rule rule) {
		notificationDAO.deleteTrigger(rule.getTriggerId(), rule.getOldTriggerName());
		notificationDAO.addTrigger(rule);
	}
	
	@DeleteMapping("/delete")
	public void deleteTrigger(@RequestParam(name = "triggerId") int triggerId, @RequestParam(name = "triggerName") String triggerName) {
		notificationDAO.deleteTrigger(triggerId, triggerName);
	}
	
	@GetMapping("/get/{id}/rules")
	public List<Trigger> getRulesByUser(@PathVariable(value = "id") int userId) {
		return notificationDAO.getTriggers(userId);
	}
	
	@GetMapping("/get/{id}/notifications")
	public List<Notification> getNotifications(@PathVariable(value = "id") int triggerId) {
		return notificationDAO.getNotifications(triggerId);
	}
	
	@GetMapping("/export/{id}")
	public List<Notification> getAllNotifications(@PathVariable(name = "id") int userId) {
		return notificationDAO.getAllNotifications(userId);
	}
}
