package myproject.data;

import java.util.ArrayList;
import java.util.List;

import myproject.exception.UtilisateurInconnuException;
import myproject.model.Utilisateur;

public class DonneesUtilisateur {

	List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public DonneesUtilisateur() {
		// Jeu d'essai
		utilisateurs.add(new Utilisateur("Robert", "licorne42"));
		utilisateurs.add(new Utilisateur("Paul", "licorne43"));
		utilisateurs.add(new Utilisateur("Jean", "licorne44"));
	}

	public Utilisateur trouverUtilisateur(String username) throws UtilisateurInconnuException {

		for (Utilisateur u : utilisateurs) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

		throw new UtilisateurInconnuException();

	}
}
