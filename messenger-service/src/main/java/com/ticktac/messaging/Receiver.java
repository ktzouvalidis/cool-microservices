package com.ticktac.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ticktac.domain.Message;

@Component
public class Receiver {
	/*@JmsListener(destination = "ticktacQueue", containerFactory = "ticktacCF")
	public void receiveMessage(Message message) {
		System.out.println("Received <" + message.getBody() + ">");
	}*/
}
