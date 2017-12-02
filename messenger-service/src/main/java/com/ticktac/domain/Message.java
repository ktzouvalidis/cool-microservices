package com.ticktac.domain;

public class Message {
	
	private int from; // ID of the sender
	private int to; // ID of the receiver
	private String senderName;
	private String body; // Content of the message
	
	public Message() {}
	
	public Message(int from, int to, String senderName, String body) {
		this.from = from;
		this.to = to;
		this.senderName = senderName;
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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
