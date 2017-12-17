package es.uc3m.tiw.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.uc3m.tiw.domains.Ticket;
import es.uc3m.tiw.domains.User;

@Entity
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;	
	private String category;
	private Date date;
	private String info;
	private String photo;
	private int soldTickets;
	private float ticketPrice;
	private String title;
	private int totalTickets;
	private String venue;
	private User user_id;
	private String status;
	
	
	//@OneToMany(mappedBy="eventBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ticket> tickets;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(String category, Date date,String info, String photo, int soldTickets,
				 float ticketPrice, String title, int totalTickets, String venue,
				 User user_id, List<Ticket> tickets) {
		
		this.category = category;
		this.date = date;
		this.info = info;
		this.photo = photo;
		this.soldTickets = soldTickets;
		this.ticketPrice = ticketPrice;
		this.title = title;
		this.totalTickets = totalTickets;
		this.venue = venue;
		this.user_id = user_id;
		this.tickets = tickets;
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
	
	@Temporal(TemporalType.TIMESTAMP)
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
	
	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="event")
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	//bi-directional many-to-one association to User
		@ManyToOne
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
	
	
}