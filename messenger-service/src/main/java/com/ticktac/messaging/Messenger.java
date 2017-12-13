package com.ticktac.messaging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticktac.domain.Message;

@RestController
@CrossOrigin
public class Messenger {
	
	@Autowired MessageDAO messageDAO;
	
	@RequestMapping(value="/sendmessage", method=RequestMethod.POST)
	public ResponseEntity<Message> sendMessage(@Validated @RequestBody Message message) {
		try {
			return new ResponseEntity<>(messageDAO.save(message), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/readmessages/{receiver}", method=RequestMethod.GET)
	public List<Message> showMessages(@PathVariable int receiver) {
		return messageDAO.findByReceiver(receiver);
	}
}
