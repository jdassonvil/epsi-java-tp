package myproject.data;

import java.util.LinkedList;
import java.util.List;

import myproject.exception.UtilisateurInconnuException;
import myproject.model.Utilisateur;

public class DonnéesUtilisateur {

	List<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();

	public DonnéesUtilisateur() {
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
