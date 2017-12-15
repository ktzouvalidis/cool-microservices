package com.user.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.data.Event;

public interface EventInterface extends CrudRepository<Event, Integer>{
	List<Event> findById(int id);

}
