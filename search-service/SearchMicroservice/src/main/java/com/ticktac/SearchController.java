package com.ticktac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticktac.domains.Event;
import com.ticktac.domains.EventDAO;
import java.util.List;

@RestController
@CrossOrigin
public class SearchController {

	@Autowired
	EventDAO evDAO;
	
	@RequestMapping(value = "/allevents", method = RequestMethod.POST)
	public List<Event> getEvents(){
		//For somer reason, it converts EventDAO into an Iterable<> instead of a List<>.
		return (List<Event>) evDAO.findAll(); 
	}
	
	@RequestMapping(value = "/Event/{title}", method = RequestMethod.POST)
	public List<Event> getEventByTitle(@PathVariable String title){
		return evDAO.findByTitle(title);
	}
}