package com.group2.commerceserver.api.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.commerceserver.models.Rule;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	@Autowired
	NotificationDAO notificationDAO;
	
	@PostMapping("/add")
	public void addNotification(@RequestBody Rule rule) {
		notificationDAO.addNotification(rule);
	}
}
