package com.ticktac.domains;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface EventDAO extends CrudRepository<Event, Integer>{
	//Normal Search
	public List<Event> findByTitle(String title);
	
	//Advanced Search - Not implemented yet.
	public List<Event> findByCategoryAndVenue(String category, String venue);
	public List<Event> findByCategoryAndVenueAndDate(String category, String venue, Date date);
}