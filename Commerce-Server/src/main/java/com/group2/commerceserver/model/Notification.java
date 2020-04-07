package com.group2.commerceserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer notificationId;

	@Column(name="TriggerID")
	private Integer triggerId;
	
	@Column(name="TransactionID")
	private Integer transactionId;
	
	@Column(name="Message")
	private String message;
	
	@Column(name="ReadStatus")
	private boolean readStatus;
	
	//Empty constructor
	public Notification() {
		
	}

	/**
	 * @return the notificationId
	 */
	public Integer getNotificationId() {
		return notificationId;
	}

	/**
	 * @return the triggerId
	 */
	public Integer getTriggerId() {
		return triggerId;
	}

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the readStatus
	 */
	public boolean isReadStatus() {
		return readStatus;
	}

	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @param triggerId the triggerId to set
	 */
	public void setTriggerId(Integer triggerId) {
		this.triggerId = triggerId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}
	
}
