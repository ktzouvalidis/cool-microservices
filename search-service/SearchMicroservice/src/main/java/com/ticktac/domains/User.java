package com.ticktac.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ticktac.domains.Event;
import com.ticktac.domains.Ticket;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String email;
	private String name;
	private String password;
	private String photo;
	private String surname;
	
	//@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Event> event;
	private List<Ticket> tickets;

	public User() {}

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user_id", cascade = CascadeType.ALL, orphanRemoval=true)
	public List<Event> getEvents() {
		return event;
	}

	public void setEvents(List<Event> events) {
		this.event = events;
	}

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="buyer")
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}