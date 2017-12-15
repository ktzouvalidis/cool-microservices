package com.user.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Event implements Serializable {
	
	@Column(name="id")
	private int id;	
	
	@Column(name="category")
	private String category;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="info")
	private String info;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="soldTickets")
	private int soldTickets;
	
	@Column(name="ticketPrice")
	private float ticketPrice;
	
	@Column(name="title")
	private String title;
	
	@Column(name="totalTickets")
	private int totalTickets;
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="user_id")
	private User user_id;
	
	@Column(name="status")
	private String status;
	
	public Event() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSoldTickets() {
		return soldTickets;
	}

	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	//@OneToMany(mappedBy="eventBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<Ticket> tickets;

}

