package com.ticktac.messaging;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.ticktac.domain.Message;

public interface MessageDAO extends JpaRepository<Message, Long> {
	public List<Message> findByTo(int to);
}
