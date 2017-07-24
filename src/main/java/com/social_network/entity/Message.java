package com.social_network.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean status;
	private boolean forPreview;

	@ManyToOne
	private User userSender;
	
	private String message;

	@ManyToOne
	private User userReceiver;

	private LocalDateTime dateOfMessageCreation;
	public Message() {
	}

	public LocalDateTime getDateOfMessageCreation() {
		return dateOfMessageCreation;
	}

	public void setDateOfMessageCreation(LocalDateTime dateOfMessageCreation) {
		this.dateOfMessageCreation = dateOfMessageCreation;
	}

	public Message(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUserReceiver() {
		return userReceiver;
	}

	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isForPreview() {
		return forPreview;
	}

	public void setForPreview(boolean forPreview) {
		this.forPreview = forPreview;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", status=" + status +
				", forPreview=" + forPreview +
				", userSender=" + userSender +
				", message='" + message + '\'' +
				", userReceiver=" + userReceiver +
				", dateOfMessageCreation=" + dateOfMessageCreation +
				'}';
	}
}
