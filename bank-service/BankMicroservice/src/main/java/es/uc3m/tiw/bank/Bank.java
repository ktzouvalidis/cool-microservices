package es.uc3m.tiw.bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.domains.BankReturn;
import es.uc3m.tiw.domains.BankTransaction;
import es.uc3m.tiw.interfaces.BankTransactionDAO;

@RestController
@CrossOrigin
public class Bank {
	BankReturn bankReturn;
	ResponseEntity<BankReturn> response;
	boolean http;
	int transactionCode;
	int httpCode;
	
	@Autowired
	BankTransactionDAO daoBT;
	
	@RequestMapping(value = "/banking", method = RequestMethod.POST)
	public ResponseEntity<BankReturn> bankingService (@RequestBody BankTransaction bankTransaction) {
		
		bankReturn = new BankReturn();
		http = true;

		
		//Check if Card Number is length 16
		if (String.valueOf(bankTransaction.getCardNumber()).length() != 16) {
			http = false;
		}
		
		//Check if Card Number is divisible by 4
		if (Integer.parseInt(bankTransaction.getCardNumber().substring(bankTransaction.getCardNumber().length()-2))%4!=0) {
			http = false;
		}
		
		//Check if CV2 Number is length 3
		if (String.valueOf(bankTransaction.getCv2Number()).length() != 3) {
			http = false;
		}
		
		//check is date is a valid date
		if (bankTransaction.getExpireMonth() < 0 || bankTransaction.getExpireMonth() > 12 
		|| bankTransaction.getExpireYear() < 11 || bankTransaction.getExpireYear() > 99) {
			http = false;
		}
		
		//If everything OK: use method to stuff shit in bank and get transaction code
		if (http == true) {
			
			//Get date and save everything to database
			java.util.Date date = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			bankTransaction.setDate(sdf.format(date));
			
			//save transaction to database
			BankTransaction outTransaction = daoBT.save(bankTransaction);
			bankReturn.setTransactionCode(outTransaction.getTransactionCode());
			return new ResponseEntity<>(bankReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bankReturn, HttpStatus.PAYMENT_REQUIRED);
		}
	}
}
