package myproject.service;

import myproject.data.MockUserData;
import myproject.data.UserDataAccess;
import myproject.exception.UnknownUserException;
import myproject.model.User;

public class AuthentificationService {
	
	private UserDataAccess userDataAccess = new MockUserData();
	
	public boolean login(String username, String password){
		
		User utilisateur;
		try {
			utilisateur = userDataAccess.findUser(username);
			return utilisateur.getPassword().equals(password);

		} catch (UnknownUserException e) {
			return false;
		}
		
	}

}
