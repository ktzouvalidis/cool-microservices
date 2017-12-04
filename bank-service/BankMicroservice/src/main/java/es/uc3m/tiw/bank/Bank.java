package es.uc3m.tiw.bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	Boolean valid;
	int transactionCode;
	int httpCode;
	
	@RequestMapping(value = "/banking", method = RequestMethod.GET)
	public @ResponseBody String bankingService(@RequestParam(value = "cardNumber", required = true) int cardNumber, 
			@RequestParam(value = "cv2Number", required = true) int cv2Number,
			@RequestParam(value = "expireMonth", required = true) int expireMonth,
			@RequestParam(value = "expireYear", required = true) int expireYear) {
		
		bankReturn = new BankReturn();
		bankReturn.setHttpCode("HTTP 2000");
		/*
		//Check if Card Number is length 16
		if (String.valueOf(cardNumber).length() != 16) {
			bankReturn.setHttpCode("HTTP 402");
		}
		
		//Check if Card Number is divisible by 4
		if (cardNumber % 4 != 0) {
			bankReturn.setHttpCode("HTTP 402");
		}
		
		//Check if CV2 Number is length 3
		if (String.valueOf(cv2Number).length() != 3) {
			bankReturn.setHttpCode("HTTP 402");
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
			bankReturn.setHttpCode("HTTP 402");
		}
		
		*/
		
		return "hello";
	}
}
