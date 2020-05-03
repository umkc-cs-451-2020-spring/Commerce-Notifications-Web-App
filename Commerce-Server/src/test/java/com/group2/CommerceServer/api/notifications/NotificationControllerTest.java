package com.group2.CommerceServer.api.notifications;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import com.group2.commerceserver.api.notifications.NotificationController;
import com.group2.commerceserver.api.notifications.NotificationDAO;
import com.group2.commerceserver.models.Filters;
import com.group2.commerceserver.models.Rule;

@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
public class NotificationControllerTest {
	
	@InjectMocks
	private NotificationController notificationController;
	
	@Mock
	private NotificationDAO notificationDAO;
	
	@Test
	public void TestAddNotification() {
		Rule rule = new Rule();
		rule.setUserId(1);
		rule.setTriggerName("TestTrigger");
		rule.setAmount((float) 100.01);
		rule.setBalance((float) 500.01);
		rule.setLocation("MO");
		rule.setStartTime("2020-04-19 12:00:00");
		rule.setEndTime("2020-04-19 12:01:00");
		rule.setCategory("Food");
	
		notificationController.addTrigger(rule);
		verify(notificationDAO, times(1)).addTrigger(rule);

	}
	
//	@Test
//	public void TestEditNotification(){
//		Rule rule = new Rule();
//		rule.setUserId(1);
//		rule.setTriggerName("TestTrigger");
//		rule.setAmount((float) 100.01);
//		rule.setBalance((float) 500.01);
//		rule.setLocation("MO");
//		rule.setStartTime("2020-04-19 12:00:00");
//		rule.setEndTime("2020-04-19 12:01:00");
//		rule.setCategory("Food");
//		
//		notificationController.editTrigger(rule);
//		verify(notificationDAO, times(1)).deleteTrigger(0, "Test Trigger");
//		verify(notificationDAO, times(1)).addTrigger(rule);
//	}
	
	@Test
	public void TestDeleteNotification(){
		Rule rule = new Rule();
		rule.setUserId(1);
		rule.setTriggerName("TestTrigger");
		rule.setAmount((float) 100.01);
		rule.setBalance((float) 500.01);
		rule.setLocation("MO");
		rule.setStartTime("2020-04-19 12:00:00");
		rule.setEndTime("2020-04-19 12:01:00");
		rule.setCategory("Food");
		
		notificationController.addTrigger(rule);
		notificationController.deleteTrigger(rule.getTriggerId(), rule.getTriggerName());
		
		verify(notificationDAO, times(1)).deleteTrigger(rule.getTriggerId(), rule.getTriggerName());
	}
	
	@Test
	public void TestGetRulesByUser() {
		Filters filters = new Filters();
		notificationController.getRulesByUser(filters);
		verify(notificationDAO, times(1)).getTriggers(filters);
	}
	
	@Test
	public void TestGetRulesByTrigger() {
		
	}
	

}
