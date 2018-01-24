package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
@Component
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;
	private String senderName;
	private Date postedDate;
	private String message;

	public void setSenderName(String string) {
		senderName = string;
	}

	public void setMessage(String string) {
		message = string;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public void setPostedDate() {
		postedDate = new java.util.Date();
	}

	public Object getSenderName() {
		return senderName;
	}

	public Object getMessage() {
		return message;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public int getMessageId() {
		return messageId;
	}

	/*
	 * This class should have four fields
	 * (messageId,senderName,postedDate,message). Out of these four fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */

}
