package com.user.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.interfaces.*;
import com.user.data.*;


@RestController
@CrossOrigin
public class Controller {
	/*
	import javax.ws.rs.client.Client;
	import javax.ws.rs.client.ClientBuilder;
	import javax.ws.rs.client.WebTarget;
	Client client = ClientBuilder.newClient();
  	
  	WebTarget webResource =
  			client.target("http://localhost:8081").path("/testing");
  			
  	
  	String customer = webResource.request("application/json").accept("application/json").get(String.class);
  	
  	Response serviceResponse = client.target("http://localhost:8081").path("/testing")
				.request(MediaType.APPLICATION_JSON).get(Response.class);
	  	
	   String micro = serviceResponse.readEntity(new GenericType<String>() {});
  			
	*/
	
	@Autowired
	private UserInterface userdao;
	
	@Autowired
	private EventInterface eventdao;
	
	@RequestMapping(value="/testing", method=RequestMethod.GET)
	public String test() {
		
		String email="a";
		String password="a";
		
		
		List<User> users=userdao.findByEmailAndPassword(email, password);
		
		int size=users.size();
		return Integer.toString(size);
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(value="email", required=true) String email) {
		
		return email;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ResponseEntity<User> signup(@Validated @RequestBody User user) {
		try {
			return new ResponseEntity<>(userdao.save(user), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		}
	}

	@RequestMapping(value="addevent", method=RequestMethod.GET)
	public String addevent() {
		
		Event event= new Event();
		
		return "moi";
		
	}
}
