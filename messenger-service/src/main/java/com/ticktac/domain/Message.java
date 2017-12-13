package com.ticktac.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"id", "sender", "receiver", "body"})
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private int sender; // ID of the sender
	private String sendername; // Sender's name - value of 'Administrator' if the sender is the Administrator
	private int receiver; // ID of the receiver
	private String body; // Content of the message
	
	public Message() {}
	
	public int getSender() {
		return sender;
	}

	public void setSender(int from) {
		this.sender = from;
	}
	
	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int to) {
		this.receiver = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
