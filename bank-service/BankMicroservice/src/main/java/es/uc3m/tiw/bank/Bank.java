package es.uc3m.tiw.bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Bank {
	@RequestMapping(value = "/banking", method = RequestMethod.GET)
	public @ResponseBody String bankingService() {
		return "This string is provided by the Bank Microservice. Good job";
	}
}
