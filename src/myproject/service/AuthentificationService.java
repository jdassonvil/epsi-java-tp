package myproject.service;

import myproject.data.DonnéesUtilisateur;
import myproject.exception.UtilisateurInconnuException;
import myproject.model.Utilisateur;

public class AuthentificationService {
	
	private DonnéesUtilisateur donnéesUtilisateur = new DonnéesUtilisateur();
	
	public boolean login(String username, String password){
		
		Utilisateur utilisateur;
		try {
			utilisateur = donnéesUtilisateur.trouverUtilisateur(username);
			return utilisateur.getPassword().equals(password);

		} catch (UtilisateurInconnuException e) {
			return false;
		}
		
	}

}
