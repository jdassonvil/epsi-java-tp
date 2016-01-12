package myproject.service;

import myproject.data.UserData;
import myproject.exception.UnknownUserException;
import myproject.model.User;

public class AuthentificationService {
	
	private UserData donnéesUtilisateur = new UserData();
	
	public boolean login(String username, String password){
		
		User utilisateur;
		try {
			utilisateur = donnéesUtilisateur.trouverUtilisateur(username);
			return utilisateur.getPassword().equals(password);

		} catch (UnknownUserException e) {
			return false;
		}
		
	}

}
