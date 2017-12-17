package es.uc3m.tiw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.domains.SignupReturn;
import es.uc3m.tiw.domains.User;
import es.uc3m.tiw.domains.UserDAO;

@RestController
@CrossOrigin
public class Controller {
	SignupReturn signupReturn;
	
	@Autowired
	UserDAO daoUs;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public SignupReturn signUp(@RequestBody User user) {
		signupReturn = new SignupReturn();
		daoUs.save(user);
		signupReturn.setView("index.jsp");
		return signupReturn;
	}

}
