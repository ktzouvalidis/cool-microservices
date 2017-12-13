package es.uc3m.tiw.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.http.HttpStatus;

@Entity
public class BankReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int transactionCode;

	
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	@Override
	public String toString() {
		return "BankReturn [transactionCode=" + transactionCode + "]";
	}
	public BankReturn(int transactionCode) {
		super();
		this.transactionCode = transactionCode;

	}
	public BankReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

