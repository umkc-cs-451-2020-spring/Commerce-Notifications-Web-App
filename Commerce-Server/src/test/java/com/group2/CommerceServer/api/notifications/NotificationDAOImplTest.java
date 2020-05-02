package com.group2.CommerceServer.api.notifications;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.group2.commerceserver.api.notifications.NotificationDAOImpl;
import com.group2.commerceserver.models.Rule;

public class NotificationDAOImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private NotificationDAOImpl notificationDAO;
	
	@Before
	public void setup(){
		notificationDAO = Mockito.mock(NotificationDAOImpl.class);
	}
	
	@Test
	public void TestAddTrigger() {
		Rule rule = new Rule();
		rule.setUserId(1);
		rule.setTriggerName("TestTrigger");
		rule.setAmount((float) 100.01);
		rule.setBalance((float) 500.01);
		rule.setLocation("MO");
		rule.setStartTime("2020-04-19 12:00:00");
		rule.setEndTime("2020-04-19 12:01:00");
		rule.setCategory("Food");
	
		notificationDAO.addTrigger(rule);
		
		Mockito.when(this.notificationDAO.addTrigger(rule)).thenReturn(true);
		verify(notificationDAO, times(1)).addTrigger(rule);
		
	}
	
	@Test
	public void TestDeleteTrigger() {
		Rule rule = new Rule();
		rule.setUserId(1);
		rule.setTriggerName("TestTrigger");
		rule.setAmount((float) 100.01);
		rule.setBalance((float) 500.01);
		rule.setLocation("MO");
		rule.setStartTime("2020-04-19 12:00:00");
		rule.setEndTime("2020-04-19 12:01:00");
		rule.setCategory("Food");
	
		notificationDAO.addTrigger(rule);
		notificationDAO.deleteTrigger(1, "TestTrigger");
		
		Mockito.when(notificationDAO.deleteTrigger(1, "TestTrigger")).thenReturn(true);
		verify(notificationDAO, times(1)).addTrigger(rule);
		
	}
	
}
