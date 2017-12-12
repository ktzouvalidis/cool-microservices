package es.uc3m.tiw.bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
			@RequestParam(value = "expireYear", required = true) int expireYear,
			@RequestParam(value = "ticketsBought", required = true) int ticketsBought,
			@RequestParam(value = "ticketPrice", required = true) int ticketPrice ) {
		
		bankReturn = new BankReturn();
		http = true;
		
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
		
		//check is date is a valid date
		if (expireMonth < 0 || expireMonth > 12 || expireYear < 11 || expireYear > 99) {
			http = false;
		}
		
		//If everything OK: use method to stuff shit in bank and get transaction code
		if (http == true) {
			//bankReturn.setTransactionCode(insertTransactionToDatabase());
			bankReturn.setTransactionCode(1);
			return new ResponseEntity<>(bankReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bankReturn, HttpStatus.PAYMENT_REQUIRED);
		}
	}
}
