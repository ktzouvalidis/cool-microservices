package es.uc3m.tiw.bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.domains.BankReturn;

@RestController
@CrossOrigin
public class Bank {
	BankReturn bankReturn;
	ResponseEntity<BankReturn> response;
	boolean http;
	int transactionCode;
	int httpCode;
	
	@RequestMapping(value = "/banking", method = RequestMethod.GET)
	public ResponseEntity<BankReturn> bankingService (
			@RequestParam(value = "cardNumber", required = true) String cardNumber,
			@RequestParam(value = "cv2Number", required = true) int cv2Number,
			@RequestParam(value = "expireMonth", required = true) int expireMonth,
			@RequestParam(value = "expireYear", required = true) int expireYear) {
		
		bankReturn = new BankReturn();
		http = true;
		
		
		//http = true => everything is OK. http = false => something wrong
		
		//Check if Card Number is length 16
		if (String.valueOf(cardNumber).length() != 16) {
			http = false;
		}
		
		//Check if Card Number is divisible by 4
		if (Integer.parseInt(cardNumber.substring(cardNumber.length()-2))%4!=0) {
			http = false;
		}
		
		//Check if CV2 Number is length 3
		if (String.valueOf(cv2Number).length() != 3) {
			http = false;
		}
		
		
		//Check if date is later to the current one
		DateFormat dateFormat = new SimpleDateFormat("yy/MM");
		Date date = new Date();
		String dateString = dateFormat.format(date);
		String yearString = dateString.substring(0, 2);
		String monthString = dateString.substring(3,5);
		int yearInt = Integer.parseInt(yearString);
		int monthInt = Integer.parseInt(monthString);
		if (expireYear < yearInt || (expireYear == yearInt && expireMonth <= monthInt)) {
			http = false;
		}
		
		//After deciding where to get the ticket info, create method for validating balance vs price of tickets
		//if (creditCard.getBalance() < totalPriceOfTickets) then HTTP 402
		
		//Create transaction code (I don't know what it is for - maybe we register transactions in database?
		//Either randomly create, or create transaction entry in a database table and return transaction code
		
		if (http == true) {
			bankReturn.setTransactionCode(1234);
			response = new ResponseEntity<>(bankReturn, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(bankReturn, HttpStatus.PAYMENT_REQUIRED);
		}
		
		
		//At the moment only returning Http Code as a string.
		return response;
	}
}
