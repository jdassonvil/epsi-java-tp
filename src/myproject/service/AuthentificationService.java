package myproject.service;

import myproject.data.Donn�esUtilisateur;
import myproject.exception.UtilisateurInconnuException;
import myproject.model.Utilisateur;

public class AuthentificationService {
	
	private Donn�esUtilisateur donn�esUtilisateur = new Donn�esUtilisateur();
	
	public boolean login(String username, String password){
		
		Utilisateur utilisateur;
		try {
			utilisateur = donn�esUtilisateur.trouverUtilisateur(username);
			return utilisateur.getPassword().equals(password);

		} catch (UtilisateurInconnuException e) {
			return false;
		}
		
	}

}
