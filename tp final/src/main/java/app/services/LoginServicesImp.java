package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Model;
import app.model.data.User;

@Service
public class LoginServicesImp implements LoginServices {

	@Autowired
	Model model;

	@Override
	public boolean registerUser(User usr) {
		return model.registerUser(usr);

	}

	@Override
	public boolean loginUser(User usr) {
		return model.loginUser(usr);
	}

}
