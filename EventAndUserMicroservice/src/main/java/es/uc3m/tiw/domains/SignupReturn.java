package es.uc3m.tiw.domains;

import java.io.Serializable;

public class SignupReturn implements Serializable {
	private String view;
	private User newUser;
	
	public SignupReturn() {
	}
	
	public String getView() {
		return this.view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public User getNewUser() {
		return this.newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
