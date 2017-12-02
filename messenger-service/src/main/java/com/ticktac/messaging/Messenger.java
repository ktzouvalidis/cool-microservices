package com.ticktac.messaging;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticktac.domain.Message;

@RestController
@CrossOrigin
public class Messenger {
	
	@RequestMapping("/sendmessage")
	public @ResponseBody String sendMessage() {
		return "message";
	}
	
	@RequestMapping("/test")
	public @ResponseBody Message showMessage() {
		return new Message(1, 2, "Kostas", "HEYYY");
	}
}
