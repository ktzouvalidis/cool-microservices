package es.uc3m.tiw.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int transaction_code;
	
	private String card_number;
	private int cv2_number;
	private int expire_month;
	private int expire_year;
	private int tickets_bought;
	private int ticket_price;
	private int total_amount;
	private String date;
	
	public BankTransaction() {
	}

	public String getCardNumber() {
		return this.card_number;
	}
	public void setCardNumber(String cardNumber) {
		this.card_number = cardNumber;
	}
	public int getCv2Number() {
		return this.cv2_number;
	}
	public void setCv2Number(int cv2Number) {
		this.cv2_number = cv2Number;
	}
	public int getExpireMonth() {
		return this.expire_month;
	}
	public void setExpireMonth(int expireMonth) {
		this.expire_month = expireMonth;
	}
	public int getExpireYear() {
		return this.expire_year;
	}
	public void setExpireYear(int expireYear) {
		this.expire_year = expireYear;
	}
	public int getTicketsBought() {
		return this.tickets_bought;
	}
	public void setTicketsBought(int ticketsBought) {
		this.tickets_bought = ticketsBought;
	}
	public int getTicketPrice() {
		return this.ticket_price;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticket_price = ticketPrice;
	}
	public int getTotalAmount() {
		return this.total_amount;
	}
	public void setTotalAmount(int totalAmount) {
		this.total_amount = totalAmount;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTransactionCode() {
		return this.transaction_code;
	}
	

}