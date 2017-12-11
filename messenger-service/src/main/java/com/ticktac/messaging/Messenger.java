package com.ticktac.messaging;

import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticktac.domain.Message;

@RestController
@CrossOrigin
public class Messenger {
	
	@Autowired MessageDAO messageDAO;
	
	@RequestMapping("sendmessage/{from}")
	public Message sendMessage(@PathVariable int from) {
		return messageDAO.save(new Message(from, 1, "heyyy"));
	}
	
	@RequestMapping("shwomessages")
	public List<Message> showMessages() {
		return messageDAO.findByTo(1);
	}
	
	/*@Autowired private JmsTemplate jmsTemplate;
	
	@RequestMapping("/sendmessage/{sender_id}/{sender_name}")
	public Message sendMessage(@PathVariable int sender_id, @PathVariable String sender_name) {
		Message message = new Message(sender_id, 1, sender_name, "HEYYY!");
		MessagePostProcessor messageProcessor = new MessagePostProcessor() {
			
			@Override
			public javax.jms.Message postProcessMessage(javax.jms.Message message) throws JMSException {
				// The ID of the User as the receiver (Should be always 1 if the logged in user is not the administrator)
				message.setIntProperty("receiver_id", 1);
				// The ID of the User as the sender
				message.setIntProperty("sender_id", sender_id);
				// The Fullname of the User as the sender 
				message.setStringProperty("sender_name", sender_name);
				
				return message;
			}
		};
		
		jmsTemplate.convertAndSend("ticktacQueue", message, messageProcessor);
		
		return message;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/readmessages/{receiver_id}")
	public List<Message> readMessages(@PathVariable int receiver_id) {
		//return (List<Message>)jmsTemplate.receiveSelectedAndConvert("ticktacQueue", "receiver_id=" + receiver_id);
		jmsTemplate.setReceiveTimeout(1); // Don't wait for messages and block the application!
		List<Message> messages = (List<Message>)jmsTemplate.receiveAndConvert("ticktacQueue");
		return messages;
	}*/
}
