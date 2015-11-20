package app.services;

import app.model.data.User;

public interface LoginServices {

	boolean registerUser(User user);

	boolean loginUser(User user);

}
