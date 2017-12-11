package com.ticktac.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	private int from; // ID of the sender
	private int to; // ID of the receiver
	private String body; // Content of the message
	
	public Message() {}
	
	public Message(int from, int to, String body) {
		this.from = from;
		this.to = to;
		this.body = body;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
