package com.user.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.user.data.Event;
import com.user.data.User;

@Entity
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idTicket;
	private int code;
	private Date dateOfSale;
	private Event eventBean;
	private User user;

	public Ticket() {
	}

	public Ticket(int code, Date dateOfSale, Event eventBean, User user){
		this.code = code;
		this.dateOfSale = dateOfSale;
		this.eventBean = eventBean;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}


	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfSale() {
		return this.dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}


	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	public Event getEventBean() {
		return this.eventBean;
	}

	public void setEventBean(Event eventBean) {
		this.eventBean = eventBean;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="buyer")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}