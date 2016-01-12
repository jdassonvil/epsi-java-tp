package myproject.service;

import myproject.data.UserData;
import myproject.exception.UnknownUserException;
import myproject.model.User;

public class AuthentificationService {
	
	private UserData donn�esUtilisateur = new UserData();
	
	public boolean login(String username, String password){
		
		User utilisateur;
		try {
			utilisateur = donn�esUtilisateur.trouverUtilisateur(username);
			return utilisateur.getPassword().equals(password);

		} catch (UnknownUserException e) {
			return false;
		}
		
	}

}
