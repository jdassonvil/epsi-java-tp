package myproject.service;

import myproject.data.DonneesUtilisateur;
import myproject.exception.UtilisateurInconnuException;
import myproject.model.Utilisateur;

public class AuthentificationService {

	private DonneesUtilisateur donnéesUtilisateur = new DonneesUtilisateur();

	public boolean login(String username, String password) {

		try {
			Utilisateur utilisateur = donnéesUtilisateur.trouverUtilisateur(username);
			return utilisateur.getPassword().equals(password);

		} catch (UtilisateurInconnuException e) {
			return false;
		}

	}

}
