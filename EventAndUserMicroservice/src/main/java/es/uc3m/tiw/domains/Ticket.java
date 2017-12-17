package es.uc3m.tiw.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import es.uc3m.tiw.domains.Event;
import es.uc3m.tiw.domains.User;

@Entity
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idTicket;
	private int code;
	private Date dateOfSale;

	//@ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name="event")
	private Event event;
	private User buyer;

	public Ticket() {
	}

	public Ticket(int code, Date dateOfSale, Event event, User buyer){
		this.code = code;
		this.dateOfSale = dateOfSale;
		this.event = event;
		this.buyer = buyer;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	
	@ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="event")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne
	@JoinColumn(name="buyer")
	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
}
