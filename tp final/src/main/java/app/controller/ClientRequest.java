package app.controller;

import app.model.data.User;

public class ClientRequest {

	public User usr;
	public int optionSelected;

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	public int getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(int optionSelected) {
		this.optionSelected = optionSelected;
	}

	@Override
	public String toString() {
		return "user: " + usr + " option: " + optionSelected;
	}
}
